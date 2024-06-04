package com.eco2mix.consumption;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "consumption")
public class Consumption {

  @Id
  @Field("_id")
  private ObjectId id;

  @Field("code_insee_region")
  private String codeInseeRegion;

  @Field("date")
  private String date;

  @Field("region")
  private String region;

  @Field("consommation_brute_gaz_totale")
  private Integer consommationBruteGazTotale;

  @Field("consommation_brute_electricite_rte")
  private Integer consommationBruteElectriciteRte;

  private String regionCodeISO;

  public String getRegionCodeISO() {
    return regionCodeISO;
  }

  public void setRegionCodeISO(String regionCodeISO) {
    this.regionCodeISO = regionCodeISO;
  }

  public Consumption(ObjectId id, String codeInseeRegion, String date, String region,
      Integer consommationBruteGazTotale, Integer consommationBruteElectriciteRte, String regionCodeISO) {
    this.id = id;
    this.codeInseeRegion = codeInseeRegion;
    this.date = date;
    this.region = region;
    this.consommationBruteGazTotale = consommationBruteGazTotale;
    this.consommationBruteElectriciteRte = consommationBruteElectriciteRte;
    this.regionCodeISO = regionCodeISO;
  }

  public String getCodeInseeRegion() {
    return codeInseeRegion;
  }

  public String getRegion() {
    return region;
  }

  public Integer getConsommationBruteGazTotale() {
    return consommationBruteGazTotale;
  }

  public Integer getConsommationBruteElectriciteRte() {
    return consommationBruteElectriciteRte;
  }

  public String getDate() {
    return date;
  }

  public ObjectId getId() {
    return id;
  }

}
