package com.eco2mix.energie;

import java.util.List;

public interface CustomEnergieRepository {
  Energie getLastDateRecordNotNull();

  List<Energie> getAllEnergiesByDate(String start, String end);

}