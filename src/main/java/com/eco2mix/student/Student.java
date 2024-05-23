package com.eco2mix.student;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student") // Indique la collection à utiliser
public class Student {
  @Id
  private Long id;
  private String name;
  private LocalDate dob;
  private Integer age;
  private String email;

  public Student() {

  }

  public Student(Long id, String name, LocalDate localDate, Integer age, String email) {

    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;

  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getAge() {
    return age;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString(){
    return String.format(
      "Student[id=%s, name='%s', dob='%s',age='%s',email='%s']",
      id, name, dob, age, email);
      }

}
