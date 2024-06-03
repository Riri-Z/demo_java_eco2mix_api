package com.eco2mix.utils;


public enum ConsumptionEnums {
  BRETAGNE("fr-bre"),
    PAYS_DE_LA_LOIRE("fr-pdl"),
    PROVENCE_ALPES_COTE_D_AZUR("fr-pac"),
    OCCITANIE("fr-occ"),
    NOUVELLE_AQUITAINE("fr-naq"),
    BOURGOGNE_FRANCHE_COMTE("fr-bfc"),
    CENTRE_VAL_DE_LOIRE("fr-cvl"),
    ILE_DE_FRANCE("fr-idf"),
    HAUTS_DE_FRANCE("fr-hdf"),
    AUVERGNE_RHONE_ALPES("fr-ara"),
    GRAND_EST("fr-ges"),
    NORMANDIE("fr-nor");

    private final String code;

    ConsumptionEnums(String code) {
      this.code = code;
    }

    public String getCode(){
      return code;
    }

    public static String getCodeByRegionName (String regionName){
      for( ConsumptionEnums region:values()){
        return region.getCode();
      }
      throw new IllegalArgumentException("Region not found: " + regionName);
    }
}
