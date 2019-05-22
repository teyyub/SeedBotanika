 

package com.botanik.excel.report;

/**
 *
 * @author teyyub , 11:25:27 PM
 */
public class ReportLocation {
    private String country;
    private String region;
    private String descOfLocation;
    private String orientationN;
    private String degreesN;
    private String minuteN;
    private String secondsN;
    private String orientationE;
    private String degreesE;
    private String minuteE;
    private String secondsE;
    private String latUnits;
    private String gridReference;
    private String gpsDatum;
    private String altitude;
    private String altitudeMethod;

    public ReportLocation() {
    }

    public ReportLocation(String country, String region, String descOfLocation, String orientationN, String degreesN, String minuteN, String secondsN, String orientationE, String degreesE, String minuteE, String secondsE, String latUnits, String gridReference, String gpsDatum, String altitude, String altitudeMethod) {
        this.country = country;
        this.region = region;
        this.descOfLocation = descOfLocation;
        this.orientationN = orientationN;
        this.degreesN = degreesN;
        this.minuteN = minuteN;
        this.secondsN = secondsN;
        this.orientationE = orientationE;
        this.degreesE = degreesE;
        this.minuteE = minuteE;
        this.secondsE = secondsE;
        this.latUnits = latUnits;
        this.gridReference = gridReference;
        this.gpsDatum = gpsDatum;
        this.altitude = altitude;
        this.altitudeMethod = altitudeMethod;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getDescOfLocation() {
        return descOfLocation;
    }

    public String getOrientationN() {
        return orientationN;
    }

    public String getDegreesN() {
        return degreesN;
    }

    public String getMinuteN() {
        return minuteN;
    }

    public String getSecondsN() {
        return secondsN;
    }

    public String getOrientationE() {
        return orientationE;
    }

    public String getDegreesE() {
        return degreesE;
    }

    public String getMinuteE() {
        return minuteE;
    }

    public String getSecondsE() {
        return secondsE;
    }

    public String getLatUnits() {
        return latUnits;
    }

    public String getGridReference() {
        return gridReference;
    }

    public String getGpsDatum() {
        return gpsDatum;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getAltitudeMethod() {
        return altitudeMethod;
    }
    
}
