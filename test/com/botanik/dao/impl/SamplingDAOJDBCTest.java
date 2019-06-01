package com.botanik.dao.impl;

import com.botanik.dao.intf.SamplingDataDAO;
import com.botanik.model.SamplingDataBase;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author USER
 */
public class SamplingDAOJDBCTest {

    SamplingDataBase model = new SamplingDataBase("123Sdf", "sd345a", "4", "23", "asdasdsda");
    SamplingDataDAO instance = new SamplingDAOJDBC();

    public SamplingDAOJDBCTest() {
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
     * Test of save method, of class SamplingDAOJDBC.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        instance.save(model);
    }

    @Test
    public void testEdit(){
        SamplingDataBase modelUpdate = new SamplingDataBase(BigDecimal.valueOf(1),"123Sdf1234", "sd345a", "4", "23", "asdasdsda");
        instance.update(modelUpdate);
    }
    
     
    @Test
    public void testSearch(){
        SamplingDataBase search = new SamplingDataBase("", "", "23", "", "");
        List<SamplingDataBase> result = instance.samplingDataBySearchModel(search);
        assertEquals(1,result.size());
    }
    
    @Test
    public void testDelete(){
        instance.delete(1);
    }
}
