package com.botanik.excel.report;

/**
 *
 * @author teyyub , 11:32:24 PM
 */
public class ReportSample {

    private String sample;
    private String found;
    private String area;
    private String percentage;
    private String note;

    public ReportSample() {
    }

    public ReportSample(String sample, String found, String area, String percentage, String note) {
        this.sample = sample;
        this.found = found;
        this.area = area;
        this.percentage = percentage;
        this.note = note;
    }

    public String getSample() {
        return sample;
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

    public String getNote() {
        return note;
    }

}
