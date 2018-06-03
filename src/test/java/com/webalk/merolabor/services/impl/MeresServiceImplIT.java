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
import org.mockito.Mockito;

/**
 *
 * @author HEM6MC
 */
public class MeresServiceImplIT {

    private MeresService meresService;
    private MeresRepository meresRepository;

    @Before
    public void setUp() {

        meresRepository = Mockito.mock(MeresRepository.class);
        meresService = new MeresServiceImpl(meresRepository);
    }

//
//    /**
//     * Test of getAllMeres method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testGetAllMeres() {
//        System.out.println("getAllMeres");
//        MeresServiceImpl instance = null;
//        List<Meres> expResult = null;
//        List<Meres> result = instance.getAllMeres();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAllMeresByDolgozo method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testDeleteAllMeresByDolgozo() {
//        System.out.println("deleteAllMeresByDolgozo");
//        Dolgozo dolgozo = null;
//        MeresServiceImpl instance = null;
//        instance.deleteAllMeresByDolgozo(dolgozo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addMeres method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testAddMeres() {
//        System.out.println("addMeres");
//        Meres meres = null;
//        MeresServiceImpl instance = null;
//        instance.addMeres(meres);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ujMeres method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testUjMeres() {
//        System.out.println("ujMeres");
//        String alkatreszszam = "";
//        int hossz = 0;
//        int suly = 0;
//        Date idopont = null;
//        Dolgozo dolgozo = null;
//        MeresServiceImpl instance = null;
//        instance.ujMeres(alkatreszszam, hossz, suly, idopont, dolgozo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMeresById method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testGetMeresById() {
//        System.out.println("getMeresById");
//        Long id = null;
//        MeresServiceImpl instance = null;
//        Meres expResult = null;
//        Meres result = instance.getMeresById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of meresExistsById method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testMeresExistsById() {
//        System.out.println("meresExistsById");
//        Long id = null;
//        MeresServiceImpl instance = null;
//        boolean expResult = false;
//        boolean result = instance.meresExistsById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteMeresById method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testDeleteMeresById() {
//        System.out.println("deleteMeresById");
//        Long id = null;
//        MeresServiceImpl instance = null;
//        instance.deleteMeresById(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAtlagSuly method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testGetAtlagSuly() {
//        System.out.println("getAtlagSuly");
//        MeresServiceImpl instance = null;
//        int expResult = 0;
//        int result = instance.getAtlagSuly();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAtlagHossz method, of class MeresServiceImpl.
//     */
//    @Test
//    public void testGetAtlagHossz() {
//        System.out.println("getAtlagHossz");
//        MeresServiceImpl instance = null;
//        int expResult = 0;
//        int result = instance.getAtlagHossz();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of atlag method, of class MeresServiceImpl.
//     */
    @Test
    public void testAtlag() {
        System.out.println("atlag");
        int sum = 10;
        int db = 5;

        int expResult = 2;
        int result = meresService.atlag(sum, db);

        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
