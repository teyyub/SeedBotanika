package com.botanik.dao.impl;

import com.botanik.dao.intf.SearchDAO;
import com.botanik.model.Search;
import com.botanik.model.SearchModel;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class SearchDAOJDBCTest {
    SearchModel model = null;
    SearchDAO instance = null;
    public SearchDAOJDBCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         instance = new SearchDAOJDBC();
         model = new SearchModel();
         model.setSeedId(-1);
         model.setCollectionNumber("");
         model.setAccesssionNumber("");
         model.setFamily("");
         model.setGenus("");
         model.setSpecies("");
         model.setRegion("");
         model.setCollectedDate(new Date("17.03.2019"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class SearchDAOJDBC.
     */
    @Test
    public void testSearch() {    
        
        List<Search> result = instance.search(model);
        assertEquals(1, result.size());
       
    }
    
}
