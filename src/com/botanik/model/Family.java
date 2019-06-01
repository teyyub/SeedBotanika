package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub , Jan 7, 2018 , 1:19:01 PM
 */
public class Family extends Base {

    private Number category_id;
    private Category category;

    public Family() {
    }

//    public Family(Number id, String name, Category category) {
//        super(id, name);
//        this.category = category;
//    }
//    
//    public Family(Number id, String name ) {
//        super(id, name);        
//    }
    
    
    public Family(BigDecimal id, String name, Category category) {
        super(id, name);
        this.category = category;
    }
    
    public Family(BigDecimal id, String name ) {
        super(id, name);        
    }
    
    
    public Family( String name ) {
        super(  name);        
    }

    public Number getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Number category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
