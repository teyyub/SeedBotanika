 

package com.botanik.export.model;

/**
 *
 * @author teyyub , 9:02:13 AM
 */
public class HerbariumExport {
    private String specimen;
    private String number;
    private String sentToKew;
    private String location;

    public HerbariumExport(String specimen, String number, String sentToKew, String location) {
        this.specimen = specimen;
        this.number = number;
        this.sentToKew = sentToKew;
        this.location = location;
    }

    public String getSpecimen() {
        return specimen;
    }

    public String getNumber() {
        return number;
    }

    public String getSentToKew() {
        return sentToKew;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return  specimen + ", " + number + ", " + sentToKew + ", " + location  ;
    }
    
}
