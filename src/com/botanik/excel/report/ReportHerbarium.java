 

package com.botanik.excel.report;

/**
 *
 * @author teyyub , 11:33:35 PM
 */
public class ReportHerbarium {
    private String specimen;
    private String number;
    private String isKew;
    private String location;

    public ReportHerbarium() {
    }

    public ReportHerbarium(String specimen, String number, String isKew, String location) {
        this.specimen = specimen;
        this.number = number;
        this.isKew = isKew;
        this.location = location;
    }

    public String getSpecimen() {
        return specimen;
    }

    public String getNumber() {
        return number;
    }

    public String getIsKew() {
        return isKew;
    }

    public String getLocation() {
        return location;
    }
    
    
}
