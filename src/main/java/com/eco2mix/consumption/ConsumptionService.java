package com.eco2mix.consumption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionService {

  @Autowired
  ConsumptionRepository consumptionRepository;

  public List<Consumption> getConsumption(String date) {

    return consumptionRepository.getConsumptionByDate(date);
  };

}
