package com.botanik.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author teyyub , 4:36:04 PM
 */
public class SearchModel {

    private Number seedId;
    private String collectionNumber;
    private String accesssionNumber;
    private Number bankedNumber;
    private String family;
    private String genus;
    private String species;
    private Date collectedDate;
    private LocalDate colDate;
    
    private String region;
    private String collector;
    private Date germinationDate;

   
    public SearchModel() {
    }

    public Number getSeedId() {
        return seedId;
    }

    public void setSeedId(Number seedId) {
        this.seedId = seedId;
    }

    public String  getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(String collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public String getAccesssionNumber() {
        return accesssionNumber;
    }

    public void setAccesssionNumber(String accesssionNumber) {
        this.accesssionNumber = accesssionNumber;
    }

 

    public Number getBankedNumber() {
        return bankedNumber;
    }

    public void setBankedNumber(Number bankedNumber) {
        this.bankedNumber = bankedNumber;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public Date getGerminationDate() {
        return germinationDate;
    }

    public void setGerminationDate(Date germinationDate) {
        this.germinationDate = germinationDate;
    }

    public LocalDate getColDate() {
        return colDate;
    }

    public void setColDate(LocalDate colDate) {
        this.colDate = colDate;
    }
    
    
    
}
