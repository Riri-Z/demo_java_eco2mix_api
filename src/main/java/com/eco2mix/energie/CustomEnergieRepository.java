package com.eco2mix.energie;

import java.util.List;

public interface CustomEnergieRepository  {
  List<Energie> getLastDateRecordNotNull();
  List<Energie> getAllEnergiesByDate(String  start,String  end);
  List<Energie> getConsumptionByDate(String  date);

}