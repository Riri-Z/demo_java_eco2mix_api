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
  @GetMapping("last-date-available")
  public ResponseEntity<String> getLastDateRecordNotNull() {

    try {
      Energie result = energieService.getLastDateAvailable();
      if (result != null) {
        return ResponseEntity.ok(result.getDate());
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception e) {
      System.err.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Une erreur s'est produite lors de la récupération de la dernière date disponible.");
    }
  }

}