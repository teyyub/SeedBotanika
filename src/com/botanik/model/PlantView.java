package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub , 12:23:37 PM
 */
public class PlantView {
    private Number id;
    private String orgInst;
    private String family;
    private String famAze;
    private String taxon;
    private String taxAze;
    private String wild;
    private Date collectedDate;
    private String collectors;
    private String country;
    private String district;
    private String location;
    private String longtitude;
    private String altitude;
    private String habitat;
    private String factor;
    private String soilType;
    private String assSpecies;
    private String plantfrom;
    private String plantDesc;
    private String herbariumLocation;
    private String herbariumNumber;
    private DefaultImage defaultImage;
    public PlantView() {
    }

    public PlantView(Number id, String orgInst, String family, String famAze, String taxon, 
            String taxAze, String wild, Date collectedDate, String collectors, String country, String district, 
            String location, String longtitude, String altitude, String habitat, String factor, String soilType,
            String assSpecies, String plantfrom, String plantDesc, 
            String hl, String hn,
            DefaultImage defaultImage) {
        this.id = id;
        this.orgInst = orgInst;
        this.family = family;
        this.famAze = famAze;
        this.taxon = taxon;
        this.taxAze = taxAze;
        this.wild = wild;
        this.collectedDate = collectedDate;
        this.collectors = collectors;
        this.country = country;
        this.district = district;
        this.location = location;
        this.longtitude = longtitude;
        this.altitude = altitude;
        this.habitat = habitat;
        this.factor = factor;
        this.soilType = soilType;
        this.assSpecies = assSpecies;
        this.plantfrom = plantfrom;
        this.herbariumLocation = hl;
        this.herbariumNumber = hn;
        this.plantDesc = plantDesc;
        this.defaultImage = defaultImage;
    }

    public Number getId() {
        return id;
    }

    public String getOrgInst() {
        return orgInst;
    }

    public String getFamily() {
        return family;
    }

    public String getFamAze() {
        return famAze;
    }

    public String getTaxon() {
        return taxon;
    }

    public String getTaxAze() {
        return taxAze;
    }

    public String getWild() {
        return wild;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public String getCollectors() {
        return collectors;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocation() {
        return location;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getFactor() {
        return factor;
    }

    public String getSoilType() {
        return soilType;
    }

    public String getAssSpecies() {
        return assSpecies;
    }

    public String getPlantfrom() {
        return plantfrom;
    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public DefaultImage getDefaultImage() {
        return defaultImage;
    }

    public String getHerbariumLocation() {
        return herbariumLocation;
    }

    public String getHerbariumNumber() {
        return herbariumNumber;
    }

    
    
    
}
