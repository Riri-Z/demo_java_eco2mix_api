package com.eco2mix.utils;

import org.springframework.core.convert.converter.Converter;

// Sometimes, data from ODRE are not defined and the result is "ND" instead of an Integer
// So we convert the result to an Integer
// To match Energie model
public class StringToIntegerConverter implements Converter<String, Integer>  {


  @Override
  public Integer convert(String source){
    try {
      return Integer.parseInt(source);
    } catch (Exception e) {
      return null;
    }
  }
}
