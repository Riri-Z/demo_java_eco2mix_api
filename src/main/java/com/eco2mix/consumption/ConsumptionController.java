package com.eco2mix.consumption;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class ConsumptionController {

  private ConsumptionService consumptionService;

  public ConsumptionController(ConsumptionService consumptionService) {
    this.consumptionService = consumptionService;
  }

  @CrossOrigin(origins = "http://localhost:5173")
  @GetMapping("consumption")
  public ResponseEntity<?> getConsumption(@RequestParam String date) throws Exception {

    try {
      List<Consumption> result = consumptionService.getConsumption(date);
      return ResponseEntity.ok(result);
    } catch (Exception error) {
      System.err.println(error);

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Une erreur s'est produite lors de la récupération de la route /consumption.");
    }

  }

}
