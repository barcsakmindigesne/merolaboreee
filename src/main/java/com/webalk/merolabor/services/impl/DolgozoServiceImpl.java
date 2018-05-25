/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;


import com.webalk.merolabor.services.DolgozoService;
import com.webalk.merolabor.entity.Dolgozo;

import com.webalk.merolabor.repository.DolgozoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HEM6MC
 */

@Service
public class DolgozoServiceImpl implements DolgozoService {
     private DolgozoRepository dolgozoRepository;
     
      @Autowired
    public void setDolgozoRepository(DolgozoRepository dolgozoRepository){
        this.dolgozoRepository = dolgozoRepository;
    }
    
    
     @Override
    public List<Dolgozo> getAllDolgozo() {
        Iterable<Dolgozo> allDolgozo = dolgozoRepository.findAll();

        List<Dolgozo> dolgozoList = new ArrayList<>();
        for (Dolgozo dolgozo : allDolgozo){
           dolgozoList.add(dolgozo);
        }
        return dolgozoList;
    }

    @Override
    public void addDolgozo(Dolgozo dolgozo) {
        dolgozoRepository.save(dolgozo);
      
    }

    @Override
    public Dolgozo getDolgozoById(Long id) {
        return dolgozoRepository.getById(id);
    }
    

    
    @Override
    public void deleteDolgozoById(Long id){
        dolgozoRepository.deleteById(id);
    }
    
    @Override
    public boolean dolgozoExistsById(Long id){
      return dolgozoRepository.existsById(id);
    }
    
    /* Nem jo? - Nem jo!!!
    @Override
    public void addMeresToDolgozo(Dolgozo dolgozo, Meres meres) {
        Dolgozo thisdolgozo = dolgozo;
        thisdolgozo.addMeresek(new Meres(meres));
        dolgozoRepository.save(thisdolgozo);
    }
    */
    
}
