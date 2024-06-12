package com.eco2mix.energie;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EnergieController {

  private EnergieService energieService;

  public EnergieController(EnergieService energieService) {
    this.energieService = energieService;
  }

  /**
   * Retreive last date available.
   *
   * @return ResponseEntity with the date as body, or an error response
   *
   */
  @CrossOrigin
  @GetMapping("last-date-available")
  public ResponseEntity<LocalDate> getLastDateRecordNotNull() {
    Energie result = energieService.getLastRecordAvailableNotNull();
    return ResponseEntity.ok(result.getDate());
  }

  @CrossOrigin
  @GetMapping("energies")
  public ResponseEntity<List<Energie>> getAllEnergies(@RequestParam String startDate, @RequestParam String endDate) {

    List<Energie> result = energieService.getAllEnergiesByDate(startDate, endDate);
    return ResponseEntity.ok(result);
  }

}