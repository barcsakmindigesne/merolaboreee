/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services;

import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Meres;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HEM6MC
 */
public interface MeresService {

    public List<Meres> getAllMeres();

    public void addMeres(Meres meres);

    public Meres getMeresById(Long id);

    public void ujMeres(String alkatreszszam, int hossz, int suly, Date idopont, Dolgozo dolgozo);

    public void deleteAllMeresByDolgozo(Dolgozo dolgozo);

    public void deleteMeresById(Long id);

    public boolean meresExistsById(Long id);
    
    public int getAtlagHossz();
    
    public int getAtlagSuly();
}
