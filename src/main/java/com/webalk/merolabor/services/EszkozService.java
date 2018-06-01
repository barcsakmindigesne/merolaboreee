/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.services;

import com.webalk.merolabor.entity.Eszkoz;
import java.util.List;

/**
 *
 * @author HEM6MC
 */
public interface EszkozService {
    public List<Eszkoz> getAllEszkoz();
    public Eszkoz getEszkozById(Long id);
    public void addEszkoz(Eszkoz eszkoz);
}
