package com.eco2mix.energie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnergieService {

  @Autowired
  EnergieRepository energieRepository;

  public List<Energie> getLastDateAvailable() {
    return energieRepository.getLastDateRecordNotNull();
  }

  public List<Energie> getAllEnergiesByDate(String start, String end) {
    return energieRepository.getAllEnergiesByDate(start, end);
  }

  public List<Energie> getConsumption (String date){
    return energieRepository.getConsumptionByDate(date);
  }
}
