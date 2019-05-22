package com.botanik.controller;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
public class UserControllerTest {
    
    public UserControllerTest() {
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
     * Test of initialize method, of class UserController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        UserController instance = new UserController();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initAccessLayout method, of class UserController.
     */
    @Test
    public void testInitAccessLayout() throws Exception {
        System.out.println("initAccessLayout");
        UserController instance = new UserController();
        instance.initAccessLayout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onEnter method, of class UserController.
     */
    @Test
    public void testOnEnter() {
        System.out.println("onEnter");
        UserController instance = new UserController();
        instance.onEnter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class UserController.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        UserController instance = new UserController();
        instance.createUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRootLayout method, of class UserController.
     */
    @Test
    public void testGetRootLayout() {
        System.out.println("getRootLayout");
        UserController instance = new UserController();
        BorderPane expResult = null;
        BorderPane result = instance.getRootLayout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStage method, of class UserController.
     */
    @Test
    public void testGetStage() {
        System.out.println("getStage");
        UserController instance = new UserController();
        Stage expResult = null;
        Stage result = instance.getStage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
