package com.eco2mix.energie;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

class CustomEnergieRepositoryImpl implements CustomEnergieRepository {
  private final MongoTemplate mongoTemplate;

  public CustomEnergieRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Energie getLastDateRecordNotNull() {

    BasicQuery query = new BasicQuery("{consommation:{$ne:null}}");
    query.with(Sort.by(Direction.DESC, "date_heure"));
    List<Energie> result = mongoTemplate.find(query, Energie.class);

    return result.get(0);

  }
}