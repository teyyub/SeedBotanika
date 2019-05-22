package com.botanik.dao.impl;

import com.botanik.dao.intf.SearchDAO;
import com.botanik.model.SearchModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author USER
 */
public class SeedDAOJDBCTest {
    
    public SeedDAOJDBCTest() {
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

    /**
     * Test of seedByModel method, of class SeedDAOJDBC.
     */
    @Test
    public void testSeedByModel() {
        System.out.println("seedByModel");
        SearchModel m = new SearchModel();
        SearchDAO instance = new SearchDAOJDBC();
        m.setSeedId(1);
        
    
    }

 
}
