/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author HEM6MC
 */


@Entity
public class Dolgozo implements Serializable {
    
    @GeneratedValue
    @Id
    private Long id;
    
    private String nev;
    private Integer eletkor;
    
    @OneToMany(mappedBy = "dolgozo")
    private List<Meres> meresek;
    
    public Dolgozo(){}

    
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

  public List<Meres> getMeresek() {
      return meresek;
  }
  
  public void setMeresek(List<Meres> meresek){
      this.meresek = meresek;
  }
    
        public void addMeresek(Meres meres){
        meresek.add(meres);
    }
    
    
    
}
