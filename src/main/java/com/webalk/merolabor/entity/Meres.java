/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author HEM6MC
 */


@Entity
public class Meres {
    
    @GeneratedValue
    @Id
    private Long id;
    
    private String alkatreszszam;
    private Integer hossz;
    private Integer suly;
    private Date idopont;
    
    @ManyToOne
    private Dolgozo dolgozo;
    
    private Meres(){}

    public Meres(Meres meres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public Meres(String alkatreszszam, int hossz, int suly, Date idopont, Dolgozo dolgozo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Meres(Dolgozo dolgozo){
    this.dolgozo = dolgozo;
    }

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlkatreszszam() {
        return alkatreszszam;
    }

    public void setAlkatreszszam(String alkatreszszam) {
        this.alkatreszszam = alkatreszszam;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public Date getIdopont() {
        return idopont;
    }

    public void setIdopont(Date idopont) {
        this.idopont = idopont;
    }
    
    public Dolgozo getDolgozo(){
        return dolgozo;
    }
    
    public void setDolgozo(Dolgozo dolgozo){
            this.dolgozo = dolgozo;
    }
    
}
