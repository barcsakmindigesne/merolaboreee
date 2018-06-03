/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers.model;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
/**
 *
 * @author HEM6MC
 */

@Data
public class DolgozoModel {
    
    @NotNull
    @Size(min = 4, max = 18)
    private String nev;
    
    @NotNull
    @Min(18)
    @Max(70)
    private Integer eletkor;
    


    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getEletkor() {
        return eletkor;
    }

    public void setEletkor(Integer eletkor) {
        this.eletkor = eletkor;
    }
    
    
        
    @Override
    public String toString() {
        return "DolgozoModel{" +
                "nev='" + nev + '\'' +
                ", eletkor=" + eletkor +
                '}';
    }
    



    
}
