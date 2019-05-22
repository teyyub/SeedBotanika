package com.botanik.model;

/**
 *
 * @author USER
 */
public class HabitatDataBase extends Base {

    private Number habitat;
    private Number landForm;
    private String geology;
    private Number aspect;
    private Number factor;
    private Number soil;
    private String associated;
    private Number slope;
    private Number landUse;
    private String siteNotes;
    private boolean isHabitatNew = true;

    public HabitatDataBase() {
    }

    public HabitatDataBase(Number habitat, Number landForm, String geology, Number aspect, Number factor, Number soil, String associated, Number slope, Number landUse, String siteNotes) {
        this.habitat = habitat;
        this.landForm = landForm;
        this.geology = geology;
        this.aspect = aspect;
        this.factor = factor;
        this.soil = soil;
        this.associated = associated;
        this.slope = slope;
        this.landUse = landUse;
        this.siteNotes = siteNotes;
    }

    public HabitatDataBase(Number id, Number habitat, Number landForm, String geology, Number aspect, Number factor, Number soil, String associated, Number slope, Number landUse, String siteNotes) {
        super(id);
        this.habitat = habitat;
        this.landForm = landForm;
        this.geology = geology;
        this.aspect = aspect;
        this.factor = factor;
        this.soil = soil;
        this.associated = associated;
        this.slope = slope;
        this.landUse = landUse;
        this.siteNotes = siteNotes;
    }

    public Number getHabitat() {
        return habitat;
    }

    public Number getLandForm() {
        return landForm;
    }

    public String getGeology() {
        return geology;
    }

    public Number getAspect() {
        return aspect;
    }

    public Number getFactor() {
        return factor;
    }

    public Number getSoil() {
        return soil;
    }

    public String getAssociated() {
        return associated;
    }

    public Number getSlope() {
        return slope;
    }

    public Number getLandUse() {
        return landUse;
    }

    public String getSiteNotes() {
        return siteNotes;
    }

    public boolean isIsHabitatNew() {
        return isHabitatNew;
    }

    public void setIsHabitatNew(boolean isHabitatNew) {
        this.isHabitatNew = isHabitatNew;
    }

}
