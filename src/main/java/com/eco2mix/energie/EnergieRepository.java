package com.eco2mix.energie;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnergieRepository extends MongoRepository<Energie, ObjectId>,CustomEnergieRepository {
  List<Energie> findByDate(String date);
}
