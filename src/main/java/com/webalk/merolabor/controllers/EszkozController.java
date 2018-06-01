/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers;


import com.webalk.merolabor.controllers.model.EszkozModel;
import com.webalk.merolabor.controllers.model.MeresModel;
import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Eszkoz;

import com.webalk.merolabor.services.DolgozoService;
import com.webalk.merolabor.services.EszkozService;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HEM6MC
 */

@Controller
@RequestMapping("/eszkozok")
public class EszkozController implements WebMvcConfigurer{
     private DolgozoService dolgozoService;
     private EszkozService eszkozService;
    
     
     
         @Autowired
    public void setDolgozoService(DolgozoService dolgozoService) {
        this.dolgozoService = dolgozoService;

    }
    
     @Autowired
    public void setEszkozService(EszkozService eszkozService) {
        this.eszkozService = eszkozService;

    }
     
     
    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllEszkoz(){
        List<Eszkoz> eszkozList = eszkozService.getAllEszkoz();
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("eszkozlistform");
        mav.addObject("eszkozList", eszkozList);
        
        return mav;
    }
     
     
     
    @GetMapping
    public ModelAndView getAll(){
        return null;
    }

    
    /*
    @GetMapping("/{id}")
    public ModelAndView getDeviceById(@PathVariable("id") Long id){
        return null;
    }
    */
    
    @GetMapping("/{id}")
    public String showForm(@PathVariable(value="id") Long id, Model model){
      
             if (!model.containsAttribute("eszkozModel")) {
        model.addAttribute("eszkozModel", new EszkozModel());
    }
             
             
             
             
   List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozo();
        
       
       
        model.addAttribute("dolgozoList", dolgozoList);
        
             Eszkoz eszkoz;
             eszkoz = eszkozService.getEszkozById(id);
             
             
             
             //return mav;
             return "eszkozform";
    }
    
    
    
      @PostMapping("/{id}")
         public String postForm(@PathVariable(value="id") Long id, @RequestParam("editId") Long editId) {
     
            
             
             
        if(dolgozoService.dolgozoExistsById(editId) == false){
        
            
        return "redirect:/eszkozok/{id}";  
   
        }
        
        Eszkoz eszkoz;
        eszkoz = eszkozService.getEszkozById(id);
        Dolgozo dolgozo;
        dolgozo = dolgozoService.getDolgozoById(editId);
        
        eszkoz.getDolgozoList().add(dolgozo);
        eszkozService.addEszkoz(eszkoz);
      
       // ra.addFlashAttribute("newMeres", meres);
        return "homeform";
      
         }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @PostMapping("/add")
    public ModelAndView addDevice(@Valid EszkozModel model){
        return null;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteDeviceById(@PathVariable("id") Long id){
        return null;
    }
    
}
