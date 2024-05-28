package com.eco2mix.accessingdatamongodb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.eco2mix.utils.StringToIntegerConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {

  @Bean
  public MongoCustomConversions customConversions() {
    List<Converter<?, ?>> converters = new ArrayList<>();
    converters.add(new StringToIntegerConverter());
    return new MongoCustomConversions(converters);
  }
}
