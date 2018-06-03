/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.repository;

import com.webalk.merolabor.entity.Eszkoz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HEM6MC
 */

@Repository
public interface EszkozRepository extends CrudRepository<Eszkoz, Long>{
     Eszkoz getById(Long id);
}
