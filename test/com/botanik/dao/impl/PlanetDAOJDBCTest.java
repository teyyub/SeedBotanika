package com.botanik.dao.impl;

import com.botanik.model.Base;
import com.botanik.model.Family;
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
public class PlanetDAOJDBCTest {

    PlanetDAOJDBC instance = new PlanetDAOJDBC();
    List<Family> expResult = null;
    Family model = null;
    List<Family> result = instance.families();
    Base base = null;

    public PlanetDAOJDBCTest() {
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
     * Test of families method, of class FamilyDAOJDBC.
     */
    @Test
    public void testFamilies() {
        System.out.println("families");
        assertEquals(1, result.size());

    }

    @Test
    public void testGenus() {
        assertEquals(1, instance.genuses().size());
    }

    /**
     * Test of save method, of class FamilyDAOJDBC.
     */
    @Test
    public void testSave() {
        System.out.println("save");

        model = new Family("asdsda");
        instance.save(model);

    }

    @Test
    public void testGenusSave() {
        base = new Base("asdasdsa");
        instance.save(base);
    }

    /**
     * Test of edit method, of class FamilyDAOJDBC.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        model = new Family(1, "asdasdsd");
        instance.edit(model);

    }

    @Test
    public void testGenusEdit() {

        base = new Base(1, "asdasdsd");
        instance.edit(base);

    }

    /**
     * Test of delete method, of class FamilyDAOJDBC.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Number id = 1;

        instance.delete(id);

    }

    @Test
    public void testGenusDelete() {
        Number id = 1;
        instance.deleteGenus(id);

    }
}
