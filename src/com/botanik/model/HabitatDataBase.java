package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class HabitatDataBase extends Base {

    private BigDecimal habitat;
    private BigDecimal landForm;
    private String geology;
    private BigDecimal aspect;
    private BigDecimal factor;
    private BigDecimal soil;
    private String associated;
    private BigDecimal slope;
    private BigDecimal landUse;
    private String siteNotes;
    private boolean isHabitatNew = true;

    public HabitatDataBase() {
    }

    public HabitatDataBase(BigDecimal habitat, BigDecimal landForm, String geology, BigDecimal aspect, BigDecimal factor, BigDecimal soil,
            String associated, BigDecimal slope, BigDecimal landUse, String siteNotes) {
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

    public HabitatDataBase(BigDecimal id, BigDecimal habitat, BigDecimal landForm, 
            String geology, BigDecimal aspect, BigDecimal factor, BigDecimal soil, String associated, BigDecimal slope, BigDecimal landUse, String siteNotes) {
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

    public BigDecimal getHabitat() {
        return habitat;
    }

    public BigDecimal getLandForm() {
        return landForm;
    }

    public String getGeology() {
        return geology;
    }

    public BigDecimal getAspect() {
        return aspect;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public BigDecimal getSoil() {
        return soil;
    }

    public String getAssociated() {
        return associated;
    }

    public BigDecimal getSlope() {
        return slope;
    }

    public BigDecimal getLandUse() {
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
