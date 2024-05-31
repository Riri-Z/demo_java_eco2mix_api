package com.eco2mix.consumption;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.ObjectId;

@Document(collection = "consumption")
public class Consumption {

  @Id
  private ObjectId id;
  private String date_heure;
  private String date;
  private String heure;
  private String code_insee_region;
  private String region;
  private Integer consommation_brute_gaz_grtgaz;
  private String statut_grtgaz;
  private Integer consommation_brute_gaz_terega;
  private String statut_terega;
  private Integer consommation_brute_gaz_totale;
  private Integer consommation_brute_electricite_rte;
  private String statut_rte;
  private Integer consommation_brute_totale;


  public Consumption() {
  }

  public Consumption(ObjectId id, String date_heure, String date, String heure, String code_insee_region, String region,
      Integer consommation_brute_gaz_grtgaz, String statut_grtgaz, Integer consommation_brute_gaz_terega,
      String statut_terega, Integer consommation_brute_gaz_totale, Integer consommation_brute_electricite_rte,
      String statut_rte, Integer consommation_brute_totale) {
    this.id = id;
    this.date_heure = date_heure;
    this.date = date;
    this.heure = heure;
    this.code_insee_region = code_insee_region;
    this.region = region;
    this.consommation_brute_gaz_grtgaz = consommation_brute_gaz_grtgaz;
    this.statut_grtgaz = statut_grtgaz;
    this.consommation_brute_gaz_terega = consommation_brute_gaz_terega;
    this.statut_terega = statut_terega;
    this.consommation_brute_gaz_totale = consommation_brute_gaz_totale;
    this.consommation_brute_electricite_rte = consommation_brute_electricite_rte;
    this.statut_rte = statut_rte;
    this.consommation_brute_totale = consommation_brute_totale;
  }

  @Override
  public String toString() {
    return "Consumption [id=" + id + ", date_heure=" + date_heure + ", date=" + date + ", heure=" + heure
        + ", code_insee_region=" + code_insee_region + ", region=" + region + ", consommation_brute_gaz_grtgaz="
        + consommation_brute_gaz_grtgaz + ", statut_grtgaz=" + statut_grtgaz + ", consommation_brute_gaz_terega="
        + consommation_brute_gaz_terega + ", statut_terega=" + statut_terega + ", consommation_brute_gaz_totale="
        + consommation_brute_gaz_totale + ", consommation_brute_electricite_rte=" + consommation_brute_electricite_rte
        + ", statut_rte=" + statut_rte + ", consommation_brute_totale=" + consommation_brute_totale + ", toString()="
        + super.toString() + "]";
  }

  public ObjectId getId() {
    return id;
  }

  public String getDate_heure() {
    return date_heure;
  }

  public String getDate() {
    return date;
  }

  public String getHeure() {
    return heure;
  }

  public String getCode_insee_region() {
    return code_insee_region;
  }

  public String getRegion() {
    return region;
  }

  public Integer getConsommation_brute_gaz_grtgaz() {
    return consommation_brute_gaz_grtgaz;
  }

  public String getStatut_grtgaz() {
    return statut_grtgaz;
  }

  public Integer getConsommation_brute_gaz_terega() {
    return consommation_brute_gaz_terega;
  }

  public String getStatut_terega() {
    return statut_terega;
  }

  public Integer getConsommation_brute_gaz_totale() {
    return consommation_brute_gaz_totale;
  }

  public Integer getConsommation_brute_electricite_rte() {
    return consommation_brute_electricite_rte;
  }

  public String getStatut_rte() {
    return statut_rte;
  }

  public Integer getConsommation_brute_totale() {
    return consommation_brute_totale;
  }


}
