/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;

import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Eszkoz;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HEM6MC
 */
public class DolgozoServiceImplIT {
    
    public DolgozoServiceImplIT() {
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
     * Test of getAllDolgozo method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testGetAllDolgozo() {
        System.out.println("getAllDolgozo");
        DolgozoServiceImpl instance = null;
        List<Dolgozo> expResult = null;
        List<Dolgozo> result = instance.getAllDolgozo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDolgozoWithoutThisEszkoz method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testGetAllDolgozoWithoutThisEszkoz() {
        System.out.println("getAllDolgozoWithoutThisEszkoz");
        Eszkoz eszkoz = null;
        DolgozoServiceImpl instance = null;
        List<Dolgozo> expResult = null;
        List<Dolgozo> result = instance.getAllDolgozoWithoutThisEszkoz(eszkoz);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDolgozoWithThisEszkoz method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testGetAllDolgozoWithThisEszkoz() {
        System.out.println("getAllDolgozoWithThisEszkoz");
        Eszkoz eszkoz = null;
        DolgozoServiceImpl instance = null;
        List<Dolgozo> expResult = null;
        List<Dolgozo> result = instance.getAllDolgozoWithThisEszkoz(eszkoz);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDolgozo method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testAddDolgozo() {
        System.out.println("addDolgozo");
        Dolgozo dolgozo = null;
        DolgozoServiceImpl instance = null;
        instance.addDolgozo(dolgozo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDolgozoById method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testGetDolgozoById() {
        System.out.println("getDolgozoById");
        Long id = null;
        DolgozoServiceImpl instance = null;
        Dolgozo expResult = null;
        Dolgozo result = instance.getDolgozoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDolgozoById method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testDeleteDolgozoById() {
        System.out.println("deleteDolgozoById");
        Long id = null;
        DolgozoServiceImpl instance = null;
        instance.deleteDolgozoById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dolgozoExistsById method, of class DolgozoServiceImpl.
     */
    @org.junit.Test
    public void testDolgozoExistsById() {
        System.out.println("dolgozoExistsById");
        Long id = null;
        DolgozoServiceImpl instance = null;
        boolean expResult = false;
        boolean result = instance.dolgozoExistsById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
