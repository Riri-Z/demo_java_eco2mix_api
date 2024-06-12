package com.eco2mix.energie;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergieRepository extends MongoRepository<Energie, ObjectId>, CustomEnergieRepository {
  List<Energie> findByDate(String date);
}
