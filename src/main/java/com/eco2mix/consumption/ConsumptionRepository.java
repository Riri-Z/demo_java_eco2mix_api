package com.eco2mix.consumption;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsumptionRepository extends MongoRepository<Consumption,ObjectId> {

  public List<Consumption> findByDate(String date);

}
