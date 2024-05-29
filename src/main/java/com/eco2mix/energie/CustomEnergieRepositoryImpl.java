package com.eco2mix.energie;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

class CustomEnergieRepositoryImpl implements CustomEnergieRepository {
  private final MongoTemplate mongoTemplate;

  public CustomEnergieRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<Energie> getLastDateRecordNotNull() {

    Criteria criteria = Criteria.where("consommation").ne(null);

    Query query = new Query(criteria);

    query.with(Sort.by(Direction.DESC, "date_heure"));

    return mongoTemplate.find(query, Energie.class);

  }

  @Override
  public List<Energie> getAllEnergiesByDate(String start, String end) {

    // Using new because we're chaining  multiple condition with and
    Criteria criteria = new Criteria().andOperator(
      Criteria.where("date").gte(start),
      Criteria.where("date").lte(end),
      Criteria.where("consommation").ne(null));

    Query query = new Query(criteria);

    return mongoTemplate.find(query, Energie.class);

  }
}