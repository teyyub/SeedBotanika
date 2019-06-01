 
package com.botanik.dao.impl;

import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author USER
 */
public class CollectionDataDAOJDBCTest {
    CollectionDataDAOJDBC instance = new CollectionDataDAOJDBC();
    public CollectionDataDAOJDBCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testSave_Base_int() {
        System.out.println("save");
        CollectionDataBase model = new CollectionDataBase("sssd", 
                "test ed", 
                "123asdf", 
                new Date(), 
                BigDecimal.valueOf(1),                 
                BigDecimal.valueOf(1), 
                BigDecimal.valueOf(1) );
    
        
        
        instance.save(model);
        
    }
    
}
