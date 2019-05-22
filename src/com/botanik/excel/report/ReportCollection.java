 

package com.botanik.excel.report;

import java.util.Date;

/**
 *
 * @author teyyub , 11:16:35 PM
 */
public class ReportCollection {
    private String organisation;
    private String projectName;
    private String wild;
    private String collectionNumber;
    private String accessionNumber;
    private Date dateCollected;
    private String mainCollector;

    public ReportCollection() {
    }

    public ReportCollection(String organisation, String projectName, String wild, String collectionNumber, String accessionNumber, Date dateCollected, String mainCollector) {
        this.organisation = organisation;
        this.projectName = projectName;
        this.wild = wild;
        this.collectionNumber = collectionNumber;
        this.accessionNumber = accessionNumber;
        this.dateCollected = dateCollected;
        this.mainCollector = mainCollector;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getWild() {
        return wild;
    }

    public String getCollectionNumber() {
        return collectionNumber;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public Date getDateCollected() {
        return dateCollected;
    }

    public String getMainCollector() {
        return mainCollector;
    }

     
    
}
