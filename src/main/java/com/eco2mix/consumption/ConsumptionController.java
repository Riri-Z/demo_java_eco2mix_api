package com.eco2mix.consumption;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConsumptionController {
  Logger logger = Logger.getLogger(getClass().getName());

  private ConsumptionService consumptionService;

  public ConsumptionController(ConsumptionService consumptionService) {
    this.consumptionService = consumptionService;
  }

  @CrossOrigin
  @GetMapping("consumption")
  public ResponseEntity<List<Consumption>> getConsumption(@RequestParam String date) {
    List<Consumption> result = consumptionService.getConsumption(date);
    return ResponseEntity.ok(result);
  }

  @CrossOrigin
  @GetMapping("consumption/date-range-available")
  public ResponseEntity<List<Consumption>> getFirstAndLastAvailableDdocument() {
    List<Consumption> result = consumptionService.getDateRangeAvailable();

    return ResponseEntity.ok(result);
  }
}
