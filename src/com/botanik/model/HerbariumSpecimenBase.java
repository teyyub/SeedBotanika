package com.botanik.model;

/**
 *
 * @author USER
 */
public class HerbariumSpecimenBase extends Base {

    private String number;
    private Number locationId;
    private Number dublicatedId;
    private Boolean herbarium;
    private String voucher;
//    private boolean isHerbariumNew = true;

    public HerbariumSpecimenBase() {
    }

    public HerbariumSpecimenBase(String number, Number locationId, Number dublicatedId, Boolean herbarium,String voucher) {
        this.number = number;
        this.locationId = locationId;
        this.dublicatedId = dublicatedId;
        this.herbarium = herbarium;
        this.voucher =  voucher;
    }

    public HerbariumSpecimenBase(Number id, String number, Number locationId, Number dublicatedId, Boolean herbarium, String voucher) {
        super(id);
        this.number = number;
        this.locationId = locationId;
        this.dublicatedId = dublicatedId;
        this.herbarium = herbarium;
        this.voucher = voucher;    
    }

    public String getNumber() {
        return number;
    }

    public Number getLocationId() {
        return locationId;
    }

    public Boolean getHerbarium() {
        return herbarium;
    }

    public Number getDublicatedId() {
        return dublicatedId;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

}
