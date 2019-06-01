package com.botanik.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author teyyub Aug 1, 2016 12:03:34 PM
 */
public class Base implements Serializable {

//    private Number id;
//    private Integer id;
    private BigDecimal id;
    private String name;
    private String daoStatus;

    public Base(BigDecimal id) {
        this.id = id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Base(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public Base(BigDecimal id, String name, String daoStatus) {
        this.id = id;
        this.name = name;
        this.daoStatus = daoStatus;
    }

//    public Base(Number id, String name, String daoStatus) {
//        this.id = id;
//        this.name = name;
//        this.daoStatus = daoStatus;
//    }
//    public Base(Number id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Base(Number id ) {
//        this.id = id;        
//    }
    public Base() {
    }

    public BigDecimal getId() {
        return id;
    }

   

    public Base(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    @Override
    public String toString() {
        return name;
    }

}
