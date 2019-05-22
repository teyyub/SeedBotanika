package com.botanik.export.model;

import java.util.List;

/**
 *
 * @author teyyub , 8:51:42 AM
 */
public class ExportListModel {

    private List<CollectionExport> collectionExport;
    private List<PlantExport> plantExport;
    private List<LocationExport> locationExport;
    private List<HabitatExport> habitatExport;
    private List<SamplingExport> samplingExport;
    private List<HerbariumExport> herbariumExport;

    public ExportListModel(List<CollectionExport> collectionExport, List<PlantExport> plantExport, List<LocationExport> locationExport, List<HabitatExport> habitatExport, List<SamplingExport> samplingExport, List<HerbariumExport> herbariumExport) {
        this.collectionExport = collectionExport;
        this.plantExport = plantExport;
        this.locationExport = locationExport;
        this.habitatExport = habitatExport;
        this.samplingExport = samplingExport;
        this.herbariumExport = herbariumExport;
    }

    public List<CollectionExport> getCollectionExport() {
        return collectionExport;
    }

    public List<PlantExport> getPlantExport() {
        return plantExport;
    }

    public List<LocationExport> getLocationExport() {
        return locationExport;
    }

    public List<HabitatExport> getHabitatExport() {
        return habitatExport;
    }

    public List<SamplingExport> getSamplingExport() {
        return samplingExport;
    }

    public List<HerbariumExport> getHerbariumExport() {
        return herbariumExport;
    }
    
    
}
