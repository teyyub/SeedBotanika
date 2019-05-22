 

package com.botanik.model;

/**
 *
 * @author teyyub , 10:00:02 AM
 */
public class SeedView {
    private Number id;
    private PlantView plantView = new PlantView();
//    private LocationDataBase location = new LocationDataBase();
//    private HabitatDataBase habitat = new HabitatDataBase();
    private SamplingDataView sampling = new SamplingDataView();
//    private HerbariumSpecimenBase herbarium = new HerbariumSpecimenBase();
//    private CollectionDataBase collection = new CollectionDataBase();
    private SeedMorphologyView morphology = new SeedMorphologyView();      
    private SeedWeightView seedWeight = new SeedWeightView();

    public SeedView(Number id , PlantView pw,SamplingDataView sdw, SeedWeightView swv, SeedMorphologyView smv) {
        this.id = id;
        this.plantView = pw;
        this.sampling = sdw;
        this.seedWeight = swv;
        this.morphology  = smv;
    }
    
    public SeedView(){
    
    }

    public Number getId() {
        return id;
    }

    public PlantView getPlantView() {
        return plantView;
    }

    public SamplingDataView getSampling() {
        return sampling;
    }

    public SeedMorphologyView getMorphology() {
        return morphology;
    }

    public SeedWeightView getSeedWeight() {
        return seedWeight;
    }

    
   
    
}
