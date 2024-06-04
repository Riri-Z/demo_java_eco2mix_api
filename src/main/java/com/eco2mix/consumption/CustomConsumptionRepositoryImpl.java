package com.eco2mix.consumption;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;

class CustomConsumptionRepositoryImpl implements CustomConsumptionRepository {
  private static final String CONSOMMATION_BRUT_ELECTRICITE = "consommation_brute_electricite_rte";
  private static final String CONSOMMATION_BRUT_GAZ = "consommation_brute_gaz_totale";
  private static final String INSEE_FIELD = "code_insee_region";
  private static final String DATE_FIELD = "date";
  private static final String REGION_FIELD = "region";

  private final MongoTemplate mongoTemplate;

  public CustomConsumptionRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<Consumption> getConsumptionByDate(String date) {

    // Filter by date
    MatchOperation matchStage = Aggregation.match(new Criteria(DATE_FIELD).is(date));

    // Group data by region
    GroupOperation groupStage = Aggregation.group(INSEE_FIELD, REGION_FIELD).sum(CONSOMMATION_BRUT_GAZ)
        .as(CONSOMMATION_BRUT_GAZ)
        .sum(CONSOMMATION_BRUT_ELECTRICITE).as(CONSOMMATION_BRUT_ELECTRICITE).first(INSEE_FIELD)
        .as(INSEE_FIELD);

    // Keep only needed field
    ProjectionOperation projectStage = Aggregation.project(INSEE_FIELD, CONSOMMATION_BRUT_GAZ,
        CONSOMMATION_BRUT_ELECTRICITE, DATE_FIELD, REGION_FIELD).andExclude("_id");

    Aggregation aggregation = Aggregation.newAggregation(matchStage, groupStage, projectStage);
    AggregationResults<Consumption> results = mongoTemplate.aggregate(aggregation, "consumption", Consumption.class);

    return results.getMappedResults();

  }
}
