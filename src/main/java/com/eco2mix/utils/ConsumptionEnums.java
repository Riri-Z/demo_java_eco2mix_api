package com.eco2mix.utils;

public enum ConsumptionEnums {
  BRETAGNE("fr-bre", "Bretagne"),
  PAYS_DE_LA_LOIRE("fr-pdl", "Pays de la Loire"),
  PROVENCE_ALPES_COTE_D_AZUR("fr-pac", "Provence-Alpes-Côte d'Azur"),
  OCCITANIE("fr-occ", "Occitanie"),
  NOUVELLE_AQUITAINE("fr-naq", "Nouvelle-Aquitaine"),
  BOURGOGNE_FRANCHE_COMTE("fr-bfc", "Bourgogne-Franche-Comté"),
  CENTRE_VAL_DE_LOIRE("fr-cvl", "Centre-Val de Loire"),
  ILE_DE_FRANCE("fr-idf", "Île-de-France"),
  HAUTS_DE_FRANCE("fr-hdf", "Hauts-de-France"),
  AUVERGNE_RHONE_ALPES("fr-ara", "Auvergne-Rhône-Alpes"),
  GRAND_EST("fr-ges", "Grand Est"),
  NORMANDIE("fr-nor", "Normandie");

  public final String code;
  private final String dbName;

  ConsumptionEnums(String code, String dbName) {
    this.code = code;
    this.dbName = dbName;
  }

  public String getCode() {
    return code;
  }

  public String getDbName() {
    return dbName;
  }

  public static String getCodeByRegionName(String regionName) {
    if (regionName == null) {
      throw new IllegalArgumentException("Region name cannot be null");
    }

    for (ConsumptionEnums region : values()) {
      if (region.getDbName().equalsIgnoreCase(regionName)) {
        return region.getCode();
      }
    }
    return null;
  }
}
