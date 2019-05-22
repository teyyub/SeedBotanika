package com.botanik.model;

/**
 *
 * @author teyyub , Jan 7, 2018 , 1:19:16 PM
 */
public class SamplingDataBase extends Base{

 
    private   String numberSample;
    private   String numberFood;
    private   String area;
    private   String percentage;
    private   String note;
    private boolean isSamplingNew = true;

    public SamplingDataBase() {
    }
    
    
    public SamplingDataBase(String numberSample, String numberFood, String area, String percentage, String note) {
        this(null, numberSample, numberFood, area, percentage, note);
    }

    public SamplingDataBase(Number id, String numberSample, String numberFood, String area, String percentage, String note) {
        super(id);
        this.numberSample = numberSample;
        this.numberFood = numberFood;
        this.area = area;
        this.percentage = percentage;
        this.note = note;
    }

    

    public String getNumberSample() {
        return numberSample;
    }

    public String getNumberFood() {
        return numberFood;
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

    public boolean isIsSamplingNew() {
        return isSamplingNew;
    }

    public void setIsSamplingNew(boolean isSamplingNew) {
        this.isSamplingNew = isSamplingNew;
    }

}
