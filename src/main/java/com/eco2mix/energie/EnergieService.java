package com.eco2mix.energie;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eco2mix.energie.exception.EnergieDataNotFoundException;

@Service
public class EnergieService {

  private EnergieRepository energieRepository;

  public EnergieService(EnergieRepository energieRepository) {
    this.energieRepository = energieRepository;
  }

  public Energie getLastRecordAvailableNotNull() {
    Energie energie = energieRepository.getLastDateRecordNotNull();
    if (energie == null) {
      throw new EnergieDataNotFoundException("No Energie data found");
    }
    return energie;
  }

  public List<Energie> getAllEnergiesByDate(String start, String end) {
    return energieRepository.getAllEnergiesByDate(start, end);
  }
}
