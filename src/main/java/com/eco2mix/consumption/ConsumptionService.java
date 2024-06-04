package com.eco2mix.consumption;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ConsumptionService {

  private ConsumptionRepository consumptionRepository;

  public ConsumptionService(ConsumptionRepository consumptionRepository) {
    this.consumptionRepository = consumptionRepository;
  }

  public List<Consumption> getConsumption(String date) {
    return consumptionRepository.getConsumptionByDate(date);
  }

}
