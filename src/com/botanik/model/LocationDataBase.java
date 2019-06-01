package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class LocationDataBase extends Base{
    
    private BigDecimal countryId;
    private BigDecimal stateId;   
    private String latitude;
    private String latMethod;
    private String grid;
    private String altitude;
    private String description;
    private String longtitude;
    private String latUnits;
    private String gps;
    private String altitudeMethod;
    private boolean isLocationNew = true;

    public LocationDataBase() {
    }

    public LocationDataBase( String latitude, String latMethod, String grid, String altitude, String description, String longtitude, String latUnits, String gps, String altitudeMethod) {
        
        this.latitude = latitude;
        this.latMethod = latMethod;
        this.grid = grid;
        this.altitude = altitude;
        this.description = description;
        this.longtitude = longtitude;
        this.latUnits = latUnits;
        this.gps = gps;
        this.altitudeMethod = altitudeMethod;
    }

    public LocationDataBase(BigDecimal id, BigDecimal countryId, BigDecimal stateId,   String latitude, String latMethod, String grid, String altitude,  String description, 
            String longtitude, String latUnits, String gps, String altitudeMethod) {
        super(id);
        this.countryId = countryId;                
        this.latitude = latitude;
        this.latMethod = latMethod;
        this.grid = grid;
        this.altitude = altitude;
        this.stateId = stateId;
        this.description = description;
        this.longtitude = longtitude;
        this.latUnits = latUnits;
        this.gps = gps;
        this.altitudeMethod = altitudeMethod;
    }

    public LocationDataBase(BigDecimal countryId, BigDecimal stateId,  String latitude, String latMethod, String grid, String altitude, String description, String longtitude, String latUnits, String gps, String altitudeMethod) {
        this.countryId = countryId;
        this.stateId = stateId;        
        this.latitude = latitude;
        this.latMethod = latMethod;
        this.grid = grid;
        this.altitude = altitude;
        this.description = description;
        this.longtitude = longtitude;
        this.latUnits = latUnits;
        this.gps = gps;
        this.altitudeMethod = altitudeMethod;
    }
    
   

    public BigDecimal getCountryId() {
        return countryId;
    }

    public BigDecimal getStateId() {
        return stateId;
    }

   
 

    public String getLatitude() {
        return latitude;
    }

    public String getLatMethod() {
        return latMethod;
    }

    public String getGrid() {
        return grid;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getDescription() {
        return description;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public String getLatUnits() {
        return latUnits;
    }

    public String getGps() {
        return gps;
    }

    public String getAltitudeMethod() {
        return altitudeMethod;
    }

    public boolean isIsLocationNew() {
        return isLocationNew;
    }

    public void setIsLocationNew(boolean isLocationNew) {
        this.isLocationNew = isLocationNew;
    }
    
    
    
}
