
package com.eco2mix.energie;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "eco2mix")
public class Energie {

  @Id
  private ObjectId id;
  private String perimetre;
  private String nature;
  private String date;
  private String heure;
  private String date_heure;
  private Integer consommation;
  private Integer prevision_j1;
  private Integer prevision_j;
  private Integer charbon;
  private Integer gaz;
  private Integer nucleaire;
  private Integer eolien;
  private Integer eolien_terrestre;
  private Integer eolien_offshore;
  private Integer solaire;
  private Integer hydraulique;
  private Integer pompage;
  private Integer bioenergies;
  private Integer ech_physiques;
  private Integer taux_co2;
  private Integer gaz_tac;
  private Integer gaz_cogen;
  private Integer gaz_ccg;
  private Integer gaz_autres;
  private Integer hydraulique_fil_eau_eclusee;
  private Integer hydraulique_lacs;
  private Integer hydraulique_step_turbinage;
  private Integer fioul;

  // Sous-classes
  private TradeEnergy tradeEnergy;
  private BioEnergies bioEnergies;
  private Battery battery;

  public Energie (){

  }

  public Energie(
      ObjectId id, String date,
      String heure,
      String date_heure,
      Integer taux_co2,
      Integer fioul,
      Integer prevision_j,
      Integer prevision_j1,
      TradeEnergy tradeEnergy,
      BioEnergies bioEnergies) {

    this.id = id;
    this.date = date;
    this.heure = heure;
    this.date_heure = date_heure;
    this.taux_co2 = taux_co2;
    this.fioul = fioul;
    this.prevision_j = prevision_j;
    this.prevision_j1 = prevision_j1;
    this.tradeEnergy = tradeEnergy;
    this.bioEnergies = bioEnergies;
  }



  public class TradeEnergy {
    private String ech_comm_angleterre;
    private Integer ech_comm_espagne;
    private Integer ech_comm_italie;
    private Integer ech_comm_suisse;
    private String ech_comm_allemagne_belgique;

    public TradeEnergy() {
    }

    public TradeEnergy(String ech_comm_angleterre, Integer ech_comm_espagne,
        Integer ech_comm_italie,
        Integer ech_comm_suisse,
        String ech_comm_allemagne_belgique) {
      this.ech_comm_allemagne_belgique = ech_comm_allemagne_belgique;
      this.ech_comm_espagne = ech_comm_espagne;
      this.ech_comm_italie = ech_comm_italie;
      this.ech_comm_suisse = ech_comm_suisse;
      this.ech_comm_allemagne_belgique = ech_comm_allemagne_belgique;
    }

    public TradeEnergy getTradeEnergy() {
      return tradeEnergy;
    }

  }

  public static class BioEnergies {
    private Integer bioenergies_dechets;
    private Integer bioenergies_biomasse;
    private Integer bioenergies_biogaz;
  }

  public static class Battery {
    private String stockage_batterie;
    private String destockage_batterie;
  }

  public ObjectId getId() {
    return id;
  }

  public String getPerimetre() {
    return perimetre;
  }

  public String getNature() {
    return nature;
  }

  public String getDate() {
    return date;
  }

  public String getHeure() {
    return heure;
  }

  public String getDate_heure() {
    return date_heure;
  }

  public Integer getConsommation() {
    return consommation;
  }

  public Integer getPrevision_j1() {
    return prevision_j1;
  }

  public Integer getPrevision_j() {
    return prevision_j;
  }

  public Integer getCharbon() {
    return charbon;
  }

  public Integer getGaz() {
    return gaz;
  }

  public Integer getNucleaire() {
    return nucleaire;
  }

  public Integer getEolien() {
    return eolien;
  }

  public Integer getEolien_terrestre() {
    return eolien_terrestre;
  }

  public Integer getEolien_offshore() {
    return eolien_offshore;
  }

  public Integer getSolaire() {
    return solaire;
  }

  public Integer getHydraulique() {
    return hydraulique;
  }

  public Integer getPompage() {
    return pompage;
  }

  public Integer getBioenergies() {
    return bioenergies;
  }

  public Integer getEch_physiques() {
    return ech_physiques;
  }

  public Integer getTaux_co2() {
    return taux_co2;
  }

  public Integer getGaz_tac() {
    return gaz_tac;
  }

  public Integer getGaz_cogen() {
    return gaz_cogen;
  }

  public Integer getGaz_ccg() {
    return gaz_ccg;
  }

  public Integer getGaz_autres() {
    return gaz_autres;
  }

  public Integer getHydraulique_fil_eau_eclusee() {
    return hydraulique_fil_eau_eclusee;
  }

  public Integer getHydraulique_lacs() {
    return hydraulique_lacs;
  }

  public Integer getHydraulique_step_turbinage() {
    return hydraulique_step_turbinage;
  }

  public Integer getFioul() {
    return fioul;
  }

  public TradeEnergy getTradeEnergy() {
    return tradeEnergy;
  }

  public BioEnergies getBioEnergies() {
    return bioEnergies;
  }

  public Battery getBattery() {
    return battery;
  }

  @Override
  public String toString() {
    return "Energie [id=" + id + ", perimetre=" + perimetre + ", nature=" + nature + ", date=" + date + ", heure="
        + heure + ", date_heure=" + date_heure + ", consommation=" + consommation + ", prevision_j1=" + prevision_j1
        + ", prevision_j=" + prevision_j + ", charbon=" + charbon + ", gaz=" + gaz + ", nucleaire=" + nucleaire
        + ", eolien=" + eolien + ", solaire=" + solaire + ", hydraulique=" + hydraulique + ", pompage=" + pompage
        + ", bioenergies=" + bioenergies + ", ech_physiques=" + ech_physiques + ", taux_co2=" + taux_co2 + ", gaz_tac="
        + gaz_tac + ", gaz_cogen=" + gaz_cogen + ", gaz_ccg=" + gaz_ccg + ", gaz_autres=" + gaz_autres
        + ", hydraulique_fil_eau_eclusee=" + hydraulique_fil_eau_eclusee + ", hydraulique_lacs=" + hydraulique_lacs
        + ", hydraulique_step_turbinage=" + hydraulique_step_turbinage + ", fioul=" + fioul + ", tradeEnergy="
        + tradeEnergy + ", bioEnergies=" + bioEnergies + ", battery=" + battery + "]";
  }

}