/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.repository;

import org.springframework.data.repository.CrudRepository;
import com.webalk.merolabor.entity.Meres;
/**
 *
 * @author HEM6MC
 */
public interface MeresRepository extends CrudRepository<Meres, Long> {
    Meres getById(Long id);
}
