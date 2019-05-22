package com.botanik.model;

import java.util.Date;

/**
 *
 * @author USER
 */
public class CollectionTableModel {

    private String collectionNumber;
    private String projectName;
    private String accessionNumber;
    private String organisation;
    private String wild;
    private String collector;
    
    private Base organizeInstitut;
    private Base wildCultivited;
    private Base collectorInstitut;
    private Date dateCollection;

    public CollectionTableModel(String collectionNumber, Base organizeInstitut, Base wildCultivited, Base collectorInstitut,
            String projectName, String accessionNumber, Date dateCollection) {
        this.collectionNumber = collectionNumber;
        this.organizeInstitut = organizeInstitut;
        this.wildCultivited = wildCultivited;
        this.collectorInstitut = collectorInstitut;
        this.projectName = projectName;
        this.accessionNumber = accessionNumber;
        this.dateCollection = dateCollection;
    }

    public CollectionTableModel(int aInt, String string, String string0, String string1, java.sql.Date date, int aInt0, int aInt1, int aInt2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(String collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public Base getOrganizeInstitut() {
        return organizeInstitut;
    }

    public void setOrganizeInstitut(Base organizeInstitut) {
        this.organizeInstitut = organizeInstitut;
    }

    public Base getWildCultivited() {
        return wildCultivited;
    }

    public void setWildCultivited(Base wildCultivited) {
        this.wildCultivited = wildCultivited;
    }

    public Base getCollectorInstitut() {
        return collectorInstitut;
    }

    public void setCollectorInstitut(Base collectorInstitut) {
        this.collectorInstitut = collectorInstitut;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public Date getDateCollection() {
        return dateCollection;
    }

    public void setDateCollection(Date dateCollection) {
        this.dateCollection = dateCollection;
    }

}
