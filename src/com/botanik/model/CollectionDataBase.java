package com.botanik.model;

import java.util.Date;

/**
 *
 * @author USER  05.05.2019
 */
public class CollectionDataBase extends Base {

    private   String collectionNumber;
    private   String projectName;
    private   String accessionNumber;
    private   Date dateCollection;
    private   Number organizeInstituteId;
    private   Number wildCultivitedId;
    private   Number collectorInstituteId;
    private   boolean isCollectionNew = true;

    public CollectionDataBase() {
    }
   
   
   
    public CollectionDataBase(Number id,
            String collectionNumber, String projectName, String accessionNumber, Date dateCollection, 
            Number organizeInstituteId, Number wildCultivitedId, 
            Number collectorInstituteId) {
        super(id);
        this.collectionNumber = collectionNumber;
        this.projectName = projectName;
        this.accessionNumber = accessionNumber;
        this.dateCollection = dateCollection;
        this.organizeInstituteId = organizeInstituteId;
        this.wildCultivitedId = wildCultivitedId;
        this.collectorInstituteId = collectorInstituteId;
    }

    public CollectionDataBase(String collectionNumber, String projectName, String accessionNumber, Date dateCollection, Number organizeInstituteId, Number wildCultivitedId, Number collectorInstituteId) {
        this.collectionNumber = collectionNumber;
        this.projectName = projectName;
        this.accessionNumber = accessionNumber;
        this.dateCollection = dateCollection;
        this.organizeInstituteId = organizeInstituteId; 
        this.wildCultivitedId = wildCultivitedId; 
        this.collectorInstituteId = collectorInstituteId;
 
    }
 

    public String getCollectionNumber() {
        return collectionNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public Date getDateCollection() {
        return dateCollection;
    }

    public Number getOrganizeInstituteId() {
        return organizeInstituteId;
    }

    public Number getWildCultivitedId() {
        return wildCultivitedId;
    }

    public Number getCollectorInstituteId() {
        return collectorInstituteId;
    }

    public boolean isIsCollectionNew() {
        return isCollectionNew;
    }

    public void setIsCollectionNew(boolean isCollectionNew) {
        this.isCollectionNew = isCollectionNew;
    }

}
