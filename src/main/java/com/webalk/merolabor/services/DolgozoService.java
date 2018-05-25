/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services;

import java.util.List;
import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Meres;

/**
 *
 * @author HEM6MC
 */
public interface DolgozoService {
     public List<Dolgozo> getAllDolgozo();
    public void addDolgozo(Dolgozo dolgozo);
    public Dolgozo getDolgozoById(Long id);
    public void deleteDolgozoById(Long id);
     public boolean dolgozoExistsById(Long id);
}
