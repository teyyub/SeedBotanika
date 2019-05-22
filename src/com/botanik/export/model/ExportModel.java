 

package com.botanik.export.model;

/**
 *
 * @author teyyub , 7:44:03 PM
 */
public class ExportModel {
    private CollectionExport collectionExport;
    private PlantExport plantExport;
    private LocationExport locationExport;
    private HabitatExport habitatExport;
    private SamplingExport samplingExport;
    private HerbariumExport herbariumExport;

    public ExportModel(CollectionExport ce, PlantExport pe, LocationExport le, HabitatExport he, SamplingExport se, HerbariumExport hre) {
        this.collectionExport = ce;
        this.plantExport = pe;
        this.locationExport = le;
        this.habitatExport = he;
        this.samplingExport = se;
        this.herbariumExport = hre;
    }

    public CollectionExport getCollectionExport() {
        return collectionExport;
    }

    public PlantExport getPlantExport() {
        return plantExport;
    }

    public LocationExport getLocationExport() {
        return locationExport;
    }

    public HabitatExport getHabitatExport() {
        return habitatExport;
    }

    public SamplingExport getSamplingExport() {
        return samplingExport;
    }

    public HerbariumExport getHerbariumExport() {
        return herbariumExport;
    }

    @Override
    public String toString() {
        return  collectionExport + ",  " + plantExport + ", " + locationExport + ", " + habitatExport + ", " + samplingExport + ", " + herbariumExport ;
    }

    
    
}
