 

package com.botanik.export.model;

/**
 *
 * @author teyyub , 8:55:58 AM
 */
public class LocationExport {
    private String country;
    private String state;
    private String district;
    private String description;
    private String orientationN;
    private String degreeN;
    private String minutesN;
    private String secondsN;
    private String orientationE;
    private String degreeE;
    private String minutesE;
    private String secondsE;
    private String lat_long_method;
    private String unit;
    private String gridReference;
    private String datum;
    private String altitude;
    private String altMethod;

    public LocationExport(String country, String state, String district, String description, String orientationN, 
            String degreeN, String minutesN, String secondsN, String orientationE, String degreeE, 
            String minutesE, String secondsE, String lat_long_method, String unit, String gridReference, 
            String datum, String altitude, String altMethod) {
        this.country = country;
        this.state = state;
        this.district = district;
        this.description = description;
        this.orientationN = orientationN;
        this.degreeN = degreeN;
        this.minutesN = minutesN;
        this.secondsN = secondsN;
        this.orientationE = orientationE;
        this.degreeE = degreeE;
        this.minutesE = minutesE;
        this.secondsE = secondsE;
        this.lat_long_method = lat_long_method;
        this.unit = unit;
        this.gridReference = gridReference;
        this.datum = datum;
        this.altitude = altitude;
        this.altMethod = altMethod;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getDescription() {
        return description;
    }

    public String getOrientationN() {
        return orientationN;
    }

    public String getDegreeN() {
        return degreeN;
    }

    public String getMinutesN() {
        return minutesN;
    }

    public String getSecondsN() {
        return secondsN;
    }

    public String getOrientationE() {
        return orientationE;
    }

    public String getDegreeE() {
        return degreeE;
    }

    public String getMinutesE() {
        return minutesE;
    }

    public String getSecondsE() {
        return secondsE;
    }

    public String getLat_long_method() {
        return lat_long_method;
    }

    

    public String getUnit() {
        return unit;
    }

    public String getGridReference() {
        return gridReference;
    }

    public String getDatum() {
        return datum;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getAltMethod() {
        return altMethod;
    }

    @Override
    public String toString() {
        return  country + " " + state + " " + district + " " + description + " " 
                + orientationN + " " + degreeN + " " + minutesN + " " + secondsN + " " 
                + orientationE + " " + degreeE + " " + minutesE + " " + secondsE + " " 
                + lat_long_method + " " + unit + " " + gridReference + " " + datum + " " 
                + altitude + " " + altMethod  ;
    }
    
    
    
    
}
