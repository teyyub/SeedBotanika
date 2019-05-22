package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub , 4:36:04 PM
 */
public class Search  {

    private Number seedId;  
    private Date collectedDate;
    private String region;
    private String family;
    private String genus;
    private String plant;
    private String habitat;
    private String collection;
    private String herbarium;

   
    public Search () {
    }

    public Number getSeedId() {
        return seedId;
    }

    public void setSeedId(Number seedId) {
        this.seedId = seedId;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getHerbarium() {
        return herbarium;
    }

    public void setHerbarium(String herbarium) {
        this.herbarium = herbarium;
    }

   
}
