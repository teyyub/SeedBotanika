package com.botanik.model;

/**
 *
 * @author USER
 */
public class HerbariumSpecimenSearch {

    private final Number id;
    private final String number;
    private final String location;
    private final String yesHerbarium;
    private final String yesToKew;
    private Boolean herbarium;
    private Boolean toKew;
 
    public HerbariumSpecimenSearch(Number id, String number, String location, String yesHerbarium, String yesToKew) {
        this.id = id;
        this.number = number;
        this.location = location;
        this.yesHerbarium = yesHerbarium;
        this.yesToKew = yesToKew;
    }

    public HerbariumSpecimenSearch(Number id, String number, String location, String yesHerbarium, String yesToKew,boolean isSpecimen, boolean  isKew) {
        this.id = id;
        this.number = number;
        this.location = location;
        this.yesHerbarium = yesHerbarium;
        this.yesToKew = yesToKew;
        this.herbarium = isSpecimen;
        this.toKew = isKew;
    }
 
 
 
 
    
    
    public Number getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getHerbarium() {
        return herbarium;
    }

    public Boolean getToKew() {
        return toKew;
    }

    public String getYesHerbarium() {
        return yesHerbarium;
    }

    public String getYesToKew() {
        return yesToKew;
    }

}
