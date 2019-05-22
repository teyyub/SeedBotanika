 

package com.botanik.excel.report;

/**
 *
 * @author teyyub , 12:20:20 AM
 */
public class ReportSeed {
    
    private ReportPlant plant = new ReportPlant();
    private ReportLocation location = new ReportLocation();
    private ReportHabitat habitat = new ReportHabitat();
    private ReportSample sampling = new ReportSample();
    private ReportHerbarium herbarium = new ReportHerbarium();
    private ReportCollection collection = new ReportCollection();
//    private SeedMorphology morphology = new SeedMorphology();      
//    private SeedWeight seedWeight = new SeedWeight();

    public ReportSeed() {
    }

    public ReportPlant getPlant() {
        return plant;
    }

    public void setPlant(ReportPlant plant) {
        this.plant = plant;
    }

    public ReportLocation getLocation() {
        return location;
    }

    public void setLocation(ReportLocation location) {
        this.location = location;
    }

    public ReportHabitat getHabitat() {
        return habitat;
    }

    public void setHabitat(ReportHabitat habitat) {
        this.habitat = habitat;
    }

    public ReportSample getSampling() {
        return sampling;
    }

    public void setSampling(ReportSample sampling) {
        this.sampling = sampling;
    }

    public ReportHerbarium getHerbarium() {
        return herbarium;
    }

    public void setHerbarium(ReportHerbarium herbarium) {
        this.herbarium = herbarium;
    }

    public ReportCollection getCollection() {
        return collection;
    }

    public void setCollection(ReportCollection collection) {
        this.collection = collection;
    }
    
    
    
    
}
