package com.eco2mix.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService { // Un "Bean" d'où le @Component || @Service (même chose, mais la sémantique change)

  @GetMapping()
  public List<Student> getStudents() {
    return List.of(

        new Student(
            1L,
            "tata",
            LocalDate.of(2022, 01, 10),
            10,
            "test@gmail.com"));
  }
}
