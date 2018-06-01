/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author HEM6MC
 */

@Data
public class EszkozModel {
    
    @NotNull
    @Size(min = 3, max = 16)
    private String eszkoznev;
    
    public String getEszkoznev() {
        return eszkoznev;
    }

    public void setEszkoznev(String eszkoznev) {
        this.eszkoznev = eszkoznev;
    }
    
}
