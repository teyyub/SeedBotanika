package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class SeedModel extends Base {

    
    private Number plantId;
    private Number locationId;
    private Number habitatId;
    private Number samplingId;
    private Number herbariumId;
    private Number collectionId;
    private Number morphologyId;      
    private Number seedWeightId;
    

    public SeedModel() {
    }

    public SeedModel(Number plantId, Number locationId, Number habitatId, Number samplingId, Number herbariumId, Number collectionId, Number morphologyId, Number seedWeightId) {
        this.plantId = plantId;
        this.locationId = locationId;
        this.habitatId = habitatId;
        this.samplingId = samplingId;
        this.herbariumId = herbariumId;
        this.collectionId = collectionId;
        this.morphologyId = morphologyId;
        this.seedWeightId = seedWeightId;
    }

    public SeedModel(Number plantId, Number locationId, Number habitatId, Number samplingId, Number herbariumId, Number collectionId, Number morphologyId, 
            Number seedWeightId, BigDecimal id) {
        super(id);
        this.plantId = plantId;
        this.locationId = locationId;
        this.habitatId = habitatId;
        this.samplingId = samplingId;
        this.herbariumId = herbariumId;
        this.collectionId = collectionId;
        this.morphologyId = morphologyId;
        this.seedWeightId = seedWeightId;
    }

    public Number getPlantId() {
        return plantId;
    }

    public void setPlantId(Number plantId) {
        this.plantId = plantId;
    }

    public Number getLocationId() {
        return locationId;
    }

    public void setLocationId(Number locationId) {
        this.locationId = locationId;
    }

    public Number getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(Number habitatId) {
        this.habitatId = habitatId;
    }

    public Number getSamplingId() {
        return samplingId;
    }

    public void setSamplingId(Number samplingId) {
        this.samplingId = samplingId;
    }

    public Number getHerbariumId() {
        return herbariumId;
    }

    public void setHerbariumId(Number herbariumId) {
        this.herbariumId = herbariumId;
    }

    public Number getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Number collectionId) {
        this.collectionId = collectionId;
    }

    public Number getMorphologyId() {
        return morphologyId;
    }

    public void setMorphologyId(Number morphologyId) {
        this.morphologyId = morphologyId;
    }

    public Number getSeedWeightId() {
        return seedWeightId;
    }

    public void setSeedWeightId(Number seedWeightId) {
        this.seedWeightId = seedWeightId;
    }
 
 
   
 
}
