/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;

import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Meres;
import com.webalk.merolabor.repository.DolgozoRepository;
import com.webalk.merolabor.repository.MeresRepository;
import com.webalk.merolabor.services.DolgozoService;
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
    
    private DolgozoService dolgozoService;
    private DolgozoRepository dolgozoRepository;
    
    
    @Before
    public void setUp() {

        meresRepository = Mockito.mock(MeresRepository.class);
        meresService = new MeresServiceImpl(meresRepository);
        
        dolgozoRepository = Mockito.mock(DolgozoRepository.class);
        dolgozoService = new DolgozoServiceImpl(dolgozoRepository);

    }

    @Test
    public void testGetMeresByNullId() throws Exception {
        System.out.println("testGetMeresByNullId");
        
        Mockito.when(meresRepository.getById(Long.valueOf(0))).thenReturn(null);

        Meres meres = meresService.getMeresById(Long.valueOf(0));

        assertNull(meres);
    }
     
    @Test
    public void getNullDolgozo() throws Exception {
        Mockito.when(dolgozoRepository.getById(Long.valueOf(0))).thenReturn(null);

        Dolgozo dolgozo = dolgozoService.getDolgozoById(Long.valueOf(0));

        assertNull(dolgozo);
    }

    @Test
    public void testAtlag() throws Exception {
        System.out.println("testAtlag");
        int sum = 12;
        int db = 5;

        float expResult = (float) 2.4;
        float result = meresService.atlag(sum, db);

        assertEquals(expResult, result, 0.0f);
    }

}
