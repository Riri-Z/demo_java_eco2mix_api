package com.eco2mix.energie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/eco2mix")
public class EnergieController {

  @Autowired
  EnergieRepository energieRepository;

  @GetMapping("last-date-available")
  public ResponseEntity<Energie> getLastDateRecordNotNull() {

    try {
      Energie result = energieRepository.getLastDateRecordNotNull();

      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

}