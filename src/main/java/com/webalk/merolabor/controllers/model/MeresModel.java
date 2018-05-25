/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers.model;

import com.webalk.merolabor.entity.Dolgozo;
import java.util.Date;
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
public class MeresModel {
    
    
    @NotNull
    @Size(min = 6, max = 6)
    private String alkatreszszam;
    
    @NotNull
    @Min(1)
    @Max(1500)
    private Integer suly;
    
    

    @NotNull
    @Min(1)
    @Max(1500)
    private Integer hossz;
    
  
    
    private Date idopont;
    private Dolgozo dolgozo;


    
    
    
    
}
