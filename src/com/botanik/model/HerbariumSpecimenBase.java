package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class HerbariumSpecimenBase extends Base {

    private String number;
    private BigDecimal locationId;
    private BigDecimal dublicatedId;
    private Boolean herbarium;
    private String voucher;
 

    public HerbariumSpecimenBase() {
    }

    public HerbariumSpecimenBase(String number, BigDecimal locationId, BigDecimal dublicatedId, Boolean herbarium, String voucher) {
        this.number = number;
        this.locationId = locationId;
        this.dublicatedId = dublicatedId;
        this.herbarium = herbarium;
        this.voucher = voucher;
    }

    public HerbariumSpecimenBase(BigDecimal id, String number, BigDecimal locationId, BigDecimal dublicatedId, Boolean herbarium, String voucher) {
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

    public BigDecimal getLocationId() {
        return locationId;
    }

    public Boolean getHerbarium() {
        return herbarium;
    }

    public BigDecimal getDublicatedId() {
        return dublicatedId;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

}
