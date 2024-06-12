package com.eco2mix.consumption;

import java.util.List;

public interface CustomConsumptionRepository {
  List<Consumption> getConsumptionByDate(String date);
  List<Consumption>  getDateRangeAvailable();
}
