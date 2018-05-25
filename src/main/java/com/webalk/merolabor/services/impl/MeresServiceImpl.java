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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HEM6MC
 */
@Service
public class MeresServiceImpl implements MeresService{
    
      private MeresRepository meresRepository;
     
      @Autowired
    public void setMeresRepository(MeresRepository meresRepository){
        this.meresRepository = meresRepository;
    }
    
    
     @Override
    public List<Meres> getAllMeres() {
        Iterable<Meres> allMeres = meresRepository.findAll();

        List<Meres> meresList = new ArrayList<>();
        for (Meres meres : allMeres){
           meresList.add(meres);
        }
        return meresList;
    }
    
    
    @Override
    public void deleteAllMeresByDolgozo(Dolgozo dolgozo) {
        Iterable<Meres> allMeres = meresRepository.findAll();
       
        for (Meres meres : allMeres){
            if(meres.getDolgozo() == dolgozo){
          
           meresRepository.delete(meres);
            }
        }
     
    }
    
    

    @Override
    public void addMeres(Meres meres) {
        meresRepository.save(meres);
    }
    
    @Override
    public void ujMeres(String alkatreszszam, int hossz, int suly, Date idopont, Dolgozo dolgozo){
    
        Meres meres = new Meres(alkatreszszam, hossz, suly, idopont, dolgozo);
        meresRepository.save(meres);
    }

    @Override
    public Meres getMeresById(Long id) {
        return meresRepository.getById(id);
    }
    
    
    @Override
    public boolean meresExistsById(Long id){
      return meresRepository.existsById(id);
    }
    
       @Override
    public void deleteMeresById(Long id){
        meresRepository.deleteById(id);
    }
}
