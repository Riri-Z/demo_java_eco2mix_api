package com.eco2mix.energie;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EnergieService {

  private EnergieRepository energieRepository;

  public  EnergieService (EnergieRepository energieRepository){
  this.energieRepository = energieRepository;
  }

  public List<Energie> getLastDateAvailable() {
    return energieRepository.getLastDateRecordNotNull();
  }

  public List<Energie> getAllEnergiesByDate(String start, String end) {
    return energieRepository.getAllEnergiesByDate(start, end);
  }
}
