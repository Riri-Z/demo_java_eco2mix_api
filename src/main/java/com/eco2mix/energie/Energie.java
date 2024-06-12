
package com.eco2mix.energie;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eco2mix")
public class Energie {

  @Id
  private ObjectId id;
  private String perimetre;
  private String nature;
  private LocalDate date;
  private String heure;
  private String date_heure;
  private Integer consommation;
  private Integer prevision_j1;
  private Integer prevision_j;
  private Integer charbon;
  private Integer gaz;
  private Integer nucleaire;
  private Integer eolien;
  private String eolien_terrestre;
  private String eolien_offshore;
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
  private String ech_comm_angleterre;
  private Integer ech_comm_espagne;
  private Integer ech_comm_italie;
  private Integer ech_comm_suisse;
  private String ech_comm_allemagne_belgique;

  public Energie() {
  }

  public Energie(ObjectId id, String perimetre, String nature, LocalDate date, String heure, String date_heure,
      Integer consommation, Integer prevision_j1, Integer prevision_j, Integer charbon, Integer gaz, Integer nucleaire,
      Integer eolien, String eolien_terrestre, String eolien_offshore, Integer solaire, Integer hydraulique,
      Integer pompage, Integer bioenergies, Integer ech_physiques, Integer taux_co2, Integer gaz_tac, Integer gaz_cogen,
      Integer gaz_ccg, Integer gaz_autres, Integer hydraulique_fil_eau_eclusee, Integer hydraulique_lacs,
      Integer hydraulique_step_turbinage, Integer fioul, String ech_comm_angleterre, Integer ech_comm_espagne,
      Integer ech_comm_italie, Integer ech_comm_suisse, String ech_comm_allemagne_belgique) {
    this.id = id;
    this.perimetre = perimetre;
    this.nature = nature;
    this.date = date;
    this.heure = heure;
    this.date_heure = date_heure;
    this.consommation = consommation;
    this.prevision_j1 = prevision_j1;
    this.prevision_j = prevision_j;
    this.charbon = charbon;
    this.gaz = gaz;
    this.nucleaire = nucleaire;
    this.eolien = eolien;
    this.eolien_terrestre = eolien_terrestre;
    this.eolien_offshore = eolien_offshore;
    this.solaire = solaire;
    this.hydraulique = hydraulique;
    this.pompage = pompage;
    this.bioenergies = bioenergies;
    this.ech_physiques = ech_physiques;
    this.taux_co2 = taux_co2;
    this.gaz_tac = gaz_tac;
    this.gaz_cogen = gaz_cogen;
    this.gaz_ccg = gaz_ccg;
    this.gaz_autres = gaz_autres;
    this.hydraulique_fil_eau_eclusee = hydraulique_fil_eau_eclusee;
    this.hydraulique_lacs = hydraulique_lacs;
    this.hydraulique_step_turbinage = hydraulique_step_turbinage;
    this.fioul = fioul;
    this.ech_comm_angleterre = ech_comm_angleterre;
    this.ech_comm_espagne = ech_comm_espagne;
    this.ech_comm_italie = ech_comm_italie;
    this.ech_comm_suisse = ech_comm_suisse;
    this.ech_comm_allemagne_belgique = ech_comm_allemagne_belgique;
  }

  public LocalDate getDate() {
    return date;
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

  public String getEolien_terrestre() {
    return eolien_terrestre;
  }

  public String getEolien_offshore() {
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

  public String getEch_comm_angleterre() {
    return ech_comm_angleterre;
  }

  public Integer getEch_comm_espagne() {
    return ech_comm_espagne;
  }

  public Integer getEch_comm_italie() {
    return ech_comm_italie;
  }

  public Integer getEch_comm_suisse() {
    return ech_comm_suisse;
  }

  public String getEch_comm_allemagne_belgique() {
    return ech_comm_allemagne_belgique;
  }

  @Override
  public String toString() {
    return "Energie [id=" + id + ", perimetre=" + perimetre + ", nature=" + nature + ", date=" + date + ", heure="
        + heure + ", date_heure=" + date_heure + ", consommation=" + consommation + ", prevision_j1=" + prevision_j1
        + ", prevision_j=" + prevision_j + ", charbon=" + charbon + ", gaz=" + gaz + ", nucleaire=" + nucleaire
        + ", eolien=" + eolien + ", eolien_terrestre=" + eolien_terrestre + ", eolien_offshore=" + eolien_offshore
        + ", solaire=" + solaire + ", hydraulique=" + hydraulique + ", pompage=" + pompage + ", bioenergies="
        + bioenergies + ", ech_physiques=" + ech_physiques + ", taux_co2=" + taux_co2 + ", gaz_tac=" + gaz_tac
        + ", gaz_cogen=" + gaz_cogen + ", gaz_ccg=" + gaz_ccg + ", gaz_autres=" + gaz_autres
        + ", hydraulique_fil_eau_eclusee=" + hydraulique_fil_eau_eclusee + ", hydraulique_lacs=" + hydraulique_lacs
        + ", hydraulique_step_turbinage=" + hydraulique_step_turbinage + ", fioul=" + fioul + ", ech_comm_angleterre="
        + ech_comm_angleterre + ", ech_comm_espagne=" + ech_comm_espagne + ", ech_comm_italie=" + ech_comm_italie
        + ", ech_comm_suisse=" + ech_comm_suisse + ", ech_comm_allemagne_belgique=" + ech_comm_allemagne_belgique + "]";
  }

}