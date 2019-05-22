/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.botanik.dao.impl;

import com.botanik.model.HabitatDataBase;
import java.util.ArrayList;
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
public class HabitatDataDAOJDBCTest {
    HabitatDataDAOJDBC instance = new HabitatDataDAOJDBC();
    List<HabitatDataBase> expResult = new ArrayList<>();    
    public HabitatDataDAOJDBCTest() {
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
     * Test of save method, of class HabitatDataDAOJDBC.
     */
    @Test
    public void testSave() {
        System.out.println("save");
//        HabitatDataBase model = new HabitatDataBase("habitat", "landForm",
//                "geology", "aspect", "factor", "soil", "site", "associated", "slope", "lasndUse");
//       
//        instance.save(model);
        
    }

    /**
     * Test of update method, of class HabitatDataDAOJDBC.
     */
    @Test
    public void testUpdate() {
//        System.out.println("update");
//        HabitatDataBase model = new HabitatDataBase(1,"habitat", "landForm", "geology", "aspect", 
//                "factor", "soil", "site", "associated", "slope", "lasndUse");
//        
//        instance.update(model);
        
    }

    /**
     * Test of delete method, of class HabitatDataDAOJDBC.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Number id = 1;        
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of AllHabitatDatas method, of class HabitatDataDAOJDBC.
     */
    @Test
    public void testAllHabitatDatas() {
        System.out.println("AllHabitatDatas");
       
        List<HabitatDataBase> result = instance.AllHabitatDatas();
        assertEquals(0, result.size());
       
    }

    /**
     * Test of habitatDataBySearchModel method, of class HabitatDataDAOJDBC.
     */
    @Test
    public void testHabitatDataBySearchModel() {
//        System.out.println("habitatDataBySearchModel");
//        HabitatDataBase model = new HabitatDataBase(1, "habitat", 
//                "", "", "", "", "", "", "", "", "") ;
// 
//        
//        List<HabitatDataBase> result = instance.habitatDataBySearchModel(model);
//        assertEquals(2, result.size());
       
    }
    
}
