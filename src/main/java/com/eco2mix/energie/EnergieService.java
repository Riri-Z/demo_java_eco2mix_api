package com.eco2mix.energie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnergieService {


  @Autowired
  EnergieRepository energieRepository;

  public Energie getLastDateAvailable () {
    return energieRepository.getLastDateRecordNotNull();
  }

}
