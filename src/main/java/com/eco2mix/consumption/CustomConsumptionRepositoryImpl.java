package com.eco2mix.consumption;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;

class CustomConsumptionRepositoryImpl implements CustomConsumptionRepository {
  private static final String CONSOMMATION_BRUT_ELECTRICITE = "consommation_brute_electricite_rte";
  private static final String CONSOMMATION_BRUT_GAZ = "consommation_brute_gaz_totale";
  private static final String INSEE_FIELD = "code_insee_region";
  private static final String DATE_FIELD = "date";
  private static final String REGION_FIELD = "region";
  private static final String COLLECTION_NAME = "consumption";

  private final MongoTemplate mongoTemplate;

  public CustomConsumptionRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<Consumption> getConsumptionByDate(String selectedDate) {

    // Filter by date
    MatchOperation matchStage = Aggregation.match(new Criteria(DATE_FIELD).is(selectedDate));

    // Group data by region
    GroupOperation groupStage = Aggregation.group(INSEE_FIELD, REGION_FIELD).sum(CONSOMMATION_BRUT_GAZ)
        .as(CONSOMMATION_BRUT_GAZ)
        .sum(CONSOMMATION_BRUT_ELECTRICITE).as(CONSOMMATION_BRUT_ELECTRICITE).first(INSEE_FIELD)
        .as(INSEE_FIELD);

    // Keep only needed field
    ProjectionOperation projectStage = Aggregation.project(INSEE_FIELD, CONSOMMATION_BRUT_GAZ,
        CONSOMMATION_BRUT_ELECTRICITE, DATE_FIELD, REGION_FIELD).andExclude("_id");

    Aggregation aggregation = Aggregation.newAggregation(matchStage, groupStage, projectStage);
    AggregationResults<Consumption> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Consumption.class);

    return results.getMappedResults();

  }

  public List<Consumption> getDateRangeAvailable() {
    // Get the last document by date (DESC)

    SortOperation sortByDateDesc = Aggregation.sort(Direction.DESC, DATE_FIELD);
    LimitOperation limitToOnlyFirstDoc = Aggregation.limit(1);

    Aggregation aggregation = Aggregation.newAggregation(sortByDateDesc, limitToOnlyFirstDoc);

    AggregationResults<Consumption> resultsLast = mongoTemplate.aggregate(aggregation, COLLECTION_NAME,
        Consumption.class);
    Consumption lastConsumption = resultsLast.getUniqueMappedResult();

    // Get the first document by date (ASC)

    SortOperation sortByDateAsc = Aggregation.sort(Direction.ASC, DATE_FIELD);
    Aggregation aggregationASC = newAggregation(sortByDateAsc, limitToOnlyFirstDoc);

    AggregationResults<Consumption> resultsFirst = mongoTemplate.aggregate(aggregationASC, COLLECTION_NAME,
        Consumption.class);
    Consumption firstConsumption = resultsFirst.getUniqueMappedResult();

    // Return a list containing the first and last documents
    return Arrays.asList(firstConsumption, lastConsumption);
  }
}
