package com.eco2mix.consumption;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eco2mix.utils.ConsumptionEnums;

@Service
public class ConsumptionService {

  private ConsumptionRepository consumptionRepository;

  public ConsumptionService(ConsumptionRepository consumptionRepository) {
    this.consumptionRepository = consumptionRepository;
  }

  public List<Consumption> getConsumption(String date) {
    List<Consumption> consumptions = consumptionRepository.getConsumptionByDate(date);

    for (Consumption item : consumptions) {

      String region = item.getRegion();

      if (region != null) {
        item.setRegionCodeISO(ConsumptionEnums.getCodeByRegionName(region));
      }
    }
    return consumptions;
  }

  public List<Consumption> getDateRangeAvailable() {

    return consumptionRepository.getDateRangeAvailable();

  }

}
