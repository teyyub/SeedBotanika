package com.botanik.excel.report;

/**
 *
 * @author teyyub , 11:30:12 PM
 */
public class ReportHabitat {

    private String habitat;
    private String species;
    private String factor;
    private String landForm;
    private String landUse;
    private String geology;
    private String slope;
    private String aspect;
    private String soilType;
    private String siteNotes;

    public ReportHabitat() {
    }

    public ReportHabitat(String habitat, String species, String factor, String landForm, String landUse, String geology, String slope, String aspect, String soilType, String siteNotes) {
        this.habitat = habitat;
        this.species = species;
        this.factor = factor;
        this.landForm = landForm;
        this.landUse = landUse;
        this.geology = geology;
        this.slope = slope;
        this.aspect = aspect;
        this.soilType = soilType;
        this.siteNotes = siteNotes;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getSpecies() {
        return species;
    }

    public String getFactor() {
        return factor;
    }

    public String getLandForm() {
        return landForm;
    }

    public String getLandUse() {
        return landUse;
    }

    public String getGeology() {
        return geology;
    }

    public String getSlope() {
        return slope;
    }

    public String getAspect() {
        return aspect;
    }

    public String getSoilType() {
        return soilType;
    }

    public String getSiteNotes() {
        return siteNotes;
    }
    
    
}
