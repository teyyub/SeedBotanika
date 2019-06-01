package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub Aug 1, 2016 9:32:28 AM
 */
public class Region {

    private BigDecimal id;
    private String name;

    public Region(String name) {
        this.name = name;
    }

    public Region() {
    }

    public Region(BigDecimal id, String name) {
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
