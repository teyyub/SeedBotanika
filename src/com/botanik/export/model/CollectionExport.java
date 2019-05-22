package com.botanik.export.model;

import java.util.Date;

/**
 *
 * @author teyyub , 8:46:28 AM
 */
public class CollectionExport {

    private String organisation;
    private String projectName;
    private String wildCultivated;
    private String colNumber;
    private String accNumber;
    private Date colDate;
    private String collectorName;
    private String otherCollName;

    public CollectionExport(String organisation, String projectName, String wildCultivated, String colNumber, String accNumber, Date colDate, String collectorName, String otherCollName) {
        this.organisation = organisation;
        this.projectName = projectName;
        this.wildCultivated = wildCultivated;
        this.colNumber = colNumber;
        this.accNumber = accNumber;
        this.colDate = colDate;
        this.collectorName = collectorName;
        this.otherCollName = otherCollName;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getWildCultivated() {
        return wildCultivated;
    }

    public String getColNumber() {
        return colNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public Date getColDate() {
        return colDate;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public String getOtherCollName() {
        return otherCollName;
    }

    @Override
    public String toString() {
        return organisation + " "
                + projectName + " " + wildCultivated + " "
                + colNumber + " " + accNumber + " " + colDate + " "
                + collectorName + " " + otherCollName;
    }

}
