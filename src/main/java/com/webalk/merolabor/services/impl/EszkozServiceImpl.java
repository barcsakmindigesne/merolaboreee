/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;
import com.webalk.merolabor.repository.EszkozRepository;
import com.webalk.merolabor.services.EszkozService;
import com.webalk.merolabor.entity.Eszkoz;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author HEM6MC
 */

@Service
public class EszkozServiceImpl implements EszkozService {
    
    
    private EszkozRepository eszkozRepository;
     
      @Autowired
    public void setEszkozRepository(EszkozRepository eszkozRepository){
        this.eszkozRepository = eszkozRepository;
    }
    
    @Override
    public List<Eszkoz> getAllEszkoz() {
        Iterable<Eszkoz> allEszkoz = eszkozRepository.findAll();

        List<Eszkoz> eszkozList = new ArrayList<>();
        for (Eszkoz eszkoz : allEszkoz){
           eszkozList.add(eszkoz);
        }
        return eszkozList;
    }
    
     @Override
    public Eszkoz getEszkozById(Long id) {
        return eszkozRepository.getById(id);
    }
    
      @Override
    public void addEszkoz(Eszkoz eszkoz) {
        eszkozRepository.save(eszkoz);
      
    }
    
    
}
