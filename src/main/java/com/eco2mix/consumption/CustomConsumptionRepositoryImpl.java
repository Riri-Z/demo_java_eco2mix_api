package com.eco2mix.consumption;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;

class CustomConsumptionRepositoryImpl implements CustomConsumptionRepository {
  private final MongoTemplate mongoTemplate;

  public CustomConsumptionRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  };

  @Override
  public List<Consumption> getConsumptionByDate(String date) {

    MatchOperation matchStage = match(new Criteria("date").is(date));

    GroupOperation groupStage = group("code_insee_region").sum("consommation_brute_gaz_totale")
        .as("consommation_brute_gaz_totale")
        .sum("consommation_brute_electricite_rte").as("consommation_brute_electricite_rte").first("code_insee_region")
        .as("code_insee_region");
    ;

    ProjectionOperation projectStage = project("code_insee_region", "consommation_brute_gaz_totale",
        "consommation_brute_electricite_rte", "date", "region").andExclude("_id");

    Aggregation aggregation = newAggregation(matchStage, groupStage, projectStage);
    AggregationResults<Consumption> results = mongoTemplate.aggregate(aggregation, "consumption", Consumption.class);

    return results.getMappedResults();

  }
}
