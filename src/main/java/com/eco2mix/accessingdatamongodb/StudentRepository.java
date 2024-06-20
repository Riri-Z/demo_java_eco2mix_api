package com.eco2mix.accessingdatamongodb;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.eco2mix.student.Student;


public interface StudentRepository extends MongoRepository<Student, Long> {

  public Student findByName(String name);
  public Student findByEmail(String email);
}