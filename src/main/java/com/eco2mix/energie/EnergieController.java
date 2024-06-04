package com.eco2mix.energie;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  @CrossOrigin(origins = "http://localhost:5173")
  @GetMapping("last-date-available")
  public ResponseEntity<?> getLastDateRecordNotNull() {

    try {
      Energie result = energieService.getLastDateAvailable().get(0);
      if (result != null) {
        return ResponseEntity.ok(result.getDate());
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception error) {
      System.err.println(error);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Une erreur s'est produite lors de la récupération de la dernière date disponible.");
    }
  }

  @CrossOrigin(origins = "http://localhost:5173")
  @GetMapping("energies")
  public ResponseEntity<?> getAllEnergies(@RequestParam String startDate, @RequestParam String endDate) {
    try {

      List<Energie> result = energieService.getAllEnergiesByDate(startDate, endDate);
      return ResponseEntity.ok(result);
    } catch (Exception error) {
      System.err.println(error);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Une erreur s'est produite lors de la récupération des données d'énergies.");
    }
  };



}