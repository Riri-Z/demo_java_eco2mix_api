package com.eco2mix.energie;


import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

class CustomEnergieRepositoryImpl implements CustomEnergieRepository {
  private static final String DATE_FIELD = "date";
  private static final String COLLECTION_NAME = "eco2mix";

  private final MongoTemplate mongoTemplate;

  public CustomEnergieRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<Energie> getFirstAndLastDocumentNotNull() {

    //  Get first document
    SortOperation sortByDateAsc = sort(Direction.ASC, DATE_FIELD);
    // Aggregation to Get the first document by asc
    Aggregation aggregationASC = newAggregation(sortByDateAsc, Aggregation.limit(1));

    AggregationResults<Energie> resultsFirst = mongoTemplate.aggregate(aggregationASC, COLLECTION_NAME,
        Energie.class);

    Energie firstEnergieDocument = resultsFirst.getUniqueMappedResult();

        //  Get last document
    SortOperation sortByDateDESC = Aggregation.sort(Direction.DESC, DATE_FIELD);



    MatchOperation matchStage = match(new Criteria("consommation").ne(null));
    Aggregation aggregationDESC = newAggregation(matchStage,sortByDateDESC, Aggregation.limit(1));


    AggregationResults<Energie> resultsLast  = mongoTemplate.aggregate(aggregationDESC, COLLECTION_NAME,
        Energie.class);
        Energie lastEnergieDocument = resultsLast.getUniqueMappedResult();


    return Arrays.asList(firstEnergieDocument, lastEnergieDocument);
  }

  @Override
  public Energie getLastDateRecordNotNull() {

    Criteria criteria = Criteria.where("consommation").ne(null);

    Query query = new Query(criteria);

    query.with(Sort.by(Direction.DESC, "date_heure"));

    return mongoTemplate.findOne(query, Energie.class);

  }

  @Override
  public List<Energie> getAllEnergiesByDate(String start, String end) {

    // Using new because we're chaining multiple condition with and
    Criteria criteria = new Criteria().andOperator(
        Criteria.where("date").gte(start),
        Criteria.where("date").lte(end));

    Query query = new Query(criteria);

    return mongoTemplate.find(query, Energie.class);

  }

}