package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub Aug 19, 2016 9:20:01 AM
 */
public class Collector extends Base {

    private int combo_no = 4000;
    private int type;

    public Collector() {
    }

    public Collector(String name, int type) {
        super(name);
        this.type = type;
    }

//    public Collector(Number id, String name) {
//        super(id, name);
//    }
    public Collector(BigDecimal id, String name) {
        super(id, name);
    }

    public int getCombo_no() {
        return combo_no;
    }

    public void setCombo_no(int combo_no) {
        this.combo_no = combo_no;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
