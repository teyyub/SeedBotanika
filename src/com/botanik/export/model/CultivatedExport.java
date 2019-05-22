package com.botanik.export.model;

import java.util.Date;

/**
 *
 * @author teyyub , 9:03:12 AM
 */
public class CultivatedExport {

    private Date firstDate;
    private Date lastDate;
    private String colName;
    private String regrown;
    private String isolation;
    private String relation;
    private String cultivated;
    private String harvested;
    private String habitat;

    public CultivatedExport(Date firstDate, Date lastDate, String colName, String regrown, String isolation, String relation, String cultivated, String harvested, String habitat) {
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.colName = colName;
        this.regrown = regrown;
        this.isolation = isolation;
        this.relation = relation;
        this.cultivated = cultivated;
        this.harvested = harvested;
        this.habitat = habitat;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public String getColName() {
        return colName;
    }

    public String getRegrown() {
        return regrown;
    }

    public String getIsolation() {
        return isolation;
    }

    public String getRelation() {
        return relation;
    }

    public String getCultivated() {
        return cultivated;
    }

    public String getHarvested() {
        return harvested;
    }

    public String getHabitat() {
        return habitat;
    }

}
