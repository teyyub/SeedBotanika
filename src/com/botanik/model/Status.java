package com.botanik.model;

/**
 *
 * @author teyyub Aug 11, 2016 11:21:01 PM
 */
public class Status extends Base {

    public Status(Number id, String name) {
        super(id, name);
    }

    public Status() {
        
    }
    
    @Override
    public String toString() {
        return super.getName();
    }

}
