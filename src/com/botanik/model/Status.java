package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub Aug 11, 2016 11:21:01 PM
 */
public class Status extends Base {

    public Status(BigDecimal id, String name) {
        super(id, name);
    }

    public Status() {

    }

    @Override
    public String toString() {
        return super.getName();
    }

}
