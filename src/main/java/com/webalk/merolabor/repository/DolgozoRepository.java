/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.repository;
import org.springframework.data.repository.CrudRepository;

import com.webalk.merolabor.entity.Dolgozo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HEM6MC
 */

@Repository
public interface DolgozoRepository extends CrudRepository<Dolgozo, Long>{
    Dolgozo getById(Long id);
}


