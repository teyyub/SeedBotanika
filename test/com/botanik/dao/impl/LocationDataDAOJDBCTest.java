package com.botanik.dao.impl;

import com.botanik.model.LocationDataBase;
import java.math.BigDecimal;
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
public class LocationDataDAOJDBCTest {

    LocationDataDAOJDBC instance = new LocationDataDAOJDBC();
    List<LocationDataBase> expResult = null;
    List<LocationDataBase> result = instance.AllLocationDatas();

    public LocationDataDAOJDBCTest() {
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
     * Test of save method, of class LocationDataDAOJDBC.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        LocationDataBase model = new LocationDataBase(BigDecimal.valueOf(1), BigDecimal.valueOf(1),
                "latitude", "latMethod", "grid", "altitude",
                "description", "longtitude", "latUnits", "gps", "altitudeMethod");

        instance.save(model);

    }

    /**
     * Test of update method, of class LocationDataDAOJDBC.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        LocationDataBase model = null;

        instance.update(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LocationDataDAOJDBC.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Number id = 2;

        instance.delete(id);

    }

    /**
     * Test of AllLocationDatas method, of class LocationDataDAOJDBC.
     */
    @Test
    public void testAllLocationDatas() {
        System.out.println("AllLocationDatas");
        
        result = instance.AllLocationDatas();
        assertEquals(1, result.size());

    }

    /**
     * Test of locationDataBySearchModel method, of class LocationDataDAOJDBC.
     */
    @Test
    public void testLocationDataBySearchModel() {
        System.out.println("locationDataBySearchModel");
        LocationDataBase model = null;

        List<LocationDataBase> expResult = null;
        List<LocationDataBase> result = instance.locationDataBySearchModel(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
