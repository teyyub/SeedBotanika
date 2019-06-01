package com.botanik.model;

import java.math.BigDecimal;
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
    private   BigDecimal organizeInstituteId;
    private   BigDecimal wildCultivitedId;
    private   BigDecimal collectorInstituteId;
    private   boolean isCollectionNew = true;

    public CollectionDataBase() {
    }
   
   
   
    public CollectionDataBase(BigDecimal id,
            String collectionNumber, String projectName, String accessionNumber, Date dateCollection, 
            BigDecimal organizeInstituteId, BigDecimal wildCultivitedId, 
            BigDecimal collectorInstituteId) {
        super(id);
        this.collectionNumber = collectionNumber;
        this.projectName = projectName;
        this.accessionNumber = accessionNumber;
        this.dateCollection = dateCollection;
        this.organizeInstituteId = organizeInstituteId;
        this.wildCultivitedId = wildCultivitedId;
        this.collectorInstituteId = collectorInstituteId;
    }

    public CollectionDataBase(String collectionNumber, String projectName, String accessionNumber, Date dateCollection, 
            BigDecimal organizeInstituteId, BigDecimal wildCultivitedId, BigDecimal collectorInstituteId) {
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

    public BigDecimal getOrganizeInstituteId() {
        return organizeInstituteId;
    }

    public BigDecimal getWildCultivitedId() {
        return wildCultivitedId;
    }

    public BigDecimal getCollectorInstituteId() {
        return collectorInstituteId;
    }

    public boolean isIsCollectionNew() {
        return isCollectionNew;
    }

    public void setIsCollectionNew(boolean isCollectionNew) {
        this.isCollectionNew = isCollectionNew;
    }

}
