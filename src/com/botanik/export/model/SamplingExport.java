package com.botanik.export.model;

/**
 *
 * @author teyyub , 9:01:09 AM
 */
public class SamplingExport {

    private String sampled;
    private String found;
    private String area;
    private String percentage;
    private String notes;

    public SamplingExport(String sampled, String found, String area, String percentage, String notes) {
        this.sampled = sampled;
        this.found = found;
        this.area = area;
        this.percentage = percentage;
        this.notes = notes;
    }

    public String getSampled() {
        return sampled;
    }

    public String getFound() {
        return found;
    }

    public String getArea() {
        return area;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return sampled + " " + found + " " + area + " " + percentage + " " + notes;
    }

}
