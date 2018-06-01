/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;

import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Meres;
import com.webalk.merolabor.repository.MeresRepository;
import com.webalk.merolabor.services.MeresService;
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
 * @author HEM6MC
 */
public class MeresServiceImplIT {
    
    public MeresServiceImplIT() {
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
     * Test of getMeresById method, of class MeresServiceImpl.
     */
    @Test
    public void testGetMeresById() {
        System.out.println("getMeresById");
       Long id = Long.valueOf(1);
        MeresServiceImpl instance = new MeresServiceImpl();
        Meres expResult = null;
        Meres result = instance.getMeresById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meresExistsById method, of class MeresServiceImpl.
     */
    @Test
    public void testMeresExistsById() {
        System.out.println("meresExistsById");
        Long id = Long.valueOf(1);
        MeresServiceImpl instance = new MeresServiceImpl();
        boolean expResult = false;
        boolean result = instance.meresExistsById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMeresById method, of class MeresServiceImpl.
     */
    @Test
    public void testDeleteMeresById() {
        System.out.println("deleteMeresById");
        Long id = Long.valueOf(1);
        MeresServiceImpl instance = new MeresServiceImpl();
        instance.deleteMeresById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
