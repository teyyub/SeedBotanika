 

package com.botanik.model;

/**
 *
 * @author teyyub , 10:00:02 AM
 */
public class DefaultSeed {
    private Number id;
    private Plant plant = new Plant();
    private LocationDataBase location = new LocationDataBase();
    private HabitatDataBase habitat = new HabitatDataBase();
    private SamplingDataBase sampling = new SamplingDataBase();
    private HerbariumSpecimenBase herbarium = new HerbariumSpecimenBase();
    private CollectionDataBase collection = new CollectionDataBase();
    private SeedMorphology morphology = new SeedMorphology();      
    private SeedWeight seedWeight = new SeedWeight();

    public DefaultSeed() {
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public LocationDataBase getLocation() {
        return location;
    }

    public void setLocation(LocationDataBase location) {
        this.location = location;
    }

    public HabitatDataBase getHabitat() {
        return habitat;
    }

    public void setHabitat(HabitatDataBase habitat) {
        this.habitat = habitat;
    }

    public SamplingDataBase getSampling() {
        return sampling;
    }

    public void setSampling(SamplingDataBase sampling) {
        this.sampling = sampling;
    }

    public HerbariumSpecimenBase getHerbarium() {
        return herbarium;
    }

    public void setHerbarium(HerbariumSpecimenBase herbarium) {
        this.herbarium = herbarium;
    }

    public CollectionDataBase getCollection() {
        return collection;
    }

    public void setCollection(CollectionDataBase collection) {
        this.collection = collection;
    }

    public SeedMorphology getMorphology() {
        return morphology;
    }

    public void setMorphology(SeedMorphology morphology) {
        this.morphology = morphology;
    }

    public SeedWeight getSeedWeight() {
        return seedWeight;
    }

    public void setSeedWeight(SeedWeight seedWeight) {
        this.seedWeight = seedWeight;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }
    
    
    
}
