/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services.impl;

import com.webalk.merolabor.services.DolgozoService;
import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Eszkoz;

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
    public DolgozoServiceImpl(DolgozoRepository dolgozoRepository) {
        this.dolgozoRepository = dolgozoRepository;
    }

    @Override
    public List<Dolgozo> getAllDolgozo() {
        Iterable<Dolgozo> allDolgozo = dolgozoRepository.findAll();

        List<Dolgozo> dolgozoList = new ArrayList<>();
        for (Dolgozo dolgozo : allDolgozo) {

            dolgozoList.add(dolgozo);

        }
        return dolgozoList;
    }

    @Override
    public List<Dolgozo> getAllDolgozoWithoutThisEszkoz(Eszkoz eszkoz)
    {
        Iterable<Dolgozo> allDolgozo = dolgozoRepository.findAll();

        List<Dolgozo> dolgozoList = new ArrayList<>();
        for (Dolgozo dolgozo : allDolgozo) {
            if(dolgozo.getEszkozList().contains(eszkoz)){
                
            }
            else{
            dolgozoList.add(dolgozo);
            }
        }
        return dolgozoList;
    
    }
    
    @Override
    public List<Dolgozo> getAllDolgozoWithThisEszkoz(Eszkoz eszkoz)
    {
        Iterable<Dolgozo> allDolgozo = dolgozoRepository.findAll();

        List<Dolgozo> dolgozoList = new ArrayList<>();
        for (Dolgozo dolgozo : allDolgozo) {
            if(dolgozo.getEszkozList().contains(eszkoz)){
            dolgozoList.add(dolgozo);
            }
            else{
            
            }
        }
        return dolgozoList;
    
    }
    
    @Override
    public void removeThisEszkozFromDolgozok(Eszkoz eszkoz){
        Iterable<Dolgozo> allDolgozo = dolgozoRepository.findAll();
        for (Dolgozo dolgozo : allDolgozo) {
            if(dolgozo.getEszkozList().contains(eszkoz)){
            dolgozo.getEszkozList().remove(eszkoz);
            }
        }
    }
    
    
    @Override
    public int dolgozokAtlagEletkora(){
        
        Iterable<Dolgozo> allDolgozo = dolgozoRepository.findAll();
        int ossz;
        int db;
        ossz = 0;
        db = 0;
        
        for (Dolgozo dolgozo : allDolgozo) {
            ossz = ossz + dolgozo.getEletkor();
            db = db + 1;
        }
        return (ossz/db);
        
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
    public void deleteDolgozoById(Long id) {
        dolgozoRepository.deleteById(id);
    }

    @Override
    public boolean dolgozoExistsById(Long id) {
        return dolgozoRepository.existsById(id);
    }


}
