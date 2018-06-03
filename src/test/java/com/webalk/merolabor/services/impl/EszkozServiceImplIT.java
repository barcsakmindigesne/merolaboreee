/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;

import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Eszkoz;
import com.webalk.merolabor.repository.DolgozoRepository;
import com.webalk.merolabor.repository.EszkozRepository;
import com.webalk.merolabor.services.EszkozService;
import com.webalk.merolabor.services.DolgozoService;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author HEM6MC
 */
public class EszkozServiceImplIT {

    private EszkozService eszkozService;
    private EszkozRepository eszkozRepository;
    private DolgozoService dolgozoService;
    private DolgozoRepository dolgozoRepository;

    @Before
    public void setUp() {
        eszkozRepository = Mockito.mock(EszkozRepository.class);
        eszkozService = new EszkozServiceImpl(eszkozRepository);

        dolgozoRepository = Mockito.mock(DolgozoRepository.class);
        dolgozoService = new DolgozoServiceImpl(dolgozoRepository);

    }

    @Test
    public void getEszkozNull() throws Exception {
        Mockito.when(eszkozRepository.getById(Long.valueOf(0))).thenReturn(null);

        Eszkoz eszkoz = eszkozService.getEszkozById(Long.valueOf(0));

        assertNull(eszkoz);
    }

    @Test
    public void getDolgozoNull() throws Exception {
        Mockito.when(dolgozoRepository.getById(Long.valueOf(0))).thenReturn(null);

        Dolgozo dolgozo = dolgozoService.getDolgozoById(Long.valueOf(0));

        assertNull(dolgozo);
    }

    @Test
    public void AllDolgozoEmpty() throws Exception {
        Mockito.when(dolgozoService.getAllDolgozo()).thenReturn(Collections.emptyList());

        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozo();

        assertEquals(dolgozoList, Collections.emptyList());
    }

    @Test(expected = RuntimeException.class)
    public void testAddEszkoz_throwsException() {
        System.out.println("testAddEszkoz_throwsException");
        when(eszkozRepository.save(any(Eszkoz.class))).thenThrow(RuntimeException.class);
        Eszkoz eszkoz = new Eszkoz();
        eszkozService.addEszkoz(eszkoz);//
    }

}
