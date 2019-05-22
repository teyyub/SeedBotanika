 

package com.botanik.export.model;

/**
 *
 * @author teyyub , 8:59:16 AM
 */
public class HabitatExport {
    private String habitat;
    private String assSpecies;
    private String factor;
    private String landForm;
    private String landUse; 
    private String geology;
    private String slope;
    private String aspect;
    private String soilType;
    private String siteNotes;

    public HabitatExport(String habitat, String assSpecies, String factor, String landForm, String landUse, String geology, String slope, String aspect, String soilType, String siteNotes) {
        this.habitat = habitat;
        this.assSpecies = assSpecies;
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

    public String getAssSpecies() {
        return assSpecies;
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

    @Override
    public String toString() {
        return  habitat + " " + assSpecies + " " + factor + " " 
                + landForm + " " + landUse + " " + geology + " " 
                + slope + " " + aspect + " " + soilType + " " + siteNotes ;
    }
    
    
}
