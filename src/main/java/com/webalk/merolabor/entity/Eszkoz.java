/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.entity;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author HEM6MC
 */

@Entity
public class Eszkoz {
    
    @GeneratedValue
    @Id
    private Long id;
    
    private String eszkoznev;

    public String getEszkoznev() {
        return eszkoznev;
    }

    public void setEszkoznev(String eszkoznev) {
        this.eszkoznev = eszkoznev;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dolgozo_eszkoz",
            joinColumns = @JoinColumn(name = "eszkoz_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dolgozo_id", referencedColumnName = "id")
    )
    
   
 
    
    
    private List<Dolgozo> dolgozoList;

    public List<Dolgozo> getDolgozoList() {
        return dolgozoList;
    }

    public void setDolgozoList(List<Dolgozo> dolgozoList) {
        this.dolgozoList = dolgozoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
    
}
