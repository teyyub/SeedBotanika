package com.botanik.dao.impl;

import com.botanik.model.SeedMorphology;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author USER
 */
public class SeedMorphologyDAOJDBCTest {

    SeedMorphologyDAOJDBC instance = new SeedMorphologyDAOJDBC();

    public SeedMorphologyDAOJDBCTest() {
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
    public void saveSeedMorphology() {
        System.out.println("update");
        SeedMorphology model = new SeedMorphology("3", BigDecimal.valueOf(1), "43", "4", "4", BigDecimal.valueOf(1), "4", BigDecimal.valueOf(1));
        instance.save(model);

    }

}
