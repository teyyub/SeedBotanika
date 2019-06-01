package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub Aug 1, 2016 8:59:08 AM
 */
public class Country {

    private BigDecimal id;
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public Country(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
