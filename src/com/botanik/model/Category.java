package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub Jul 19, 2016 11:22:08 AM
 */
public class Category extends Base {

    private String description;

    public Category() {
    }

//    public Category(Number id, String name) {
//        super(id, name);
//    }
    public Category(BigDecimal id, String name) {
        super(id, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
