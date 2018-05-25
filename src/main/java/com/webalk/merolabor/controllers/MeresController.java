/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers;

import com.webalk.merolabor.entity.Meres;
import com.webalk.merolabor.controllers.model.MeresModel;
import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.services.DolgozoService;

import com.webalk.merolabor.services.MeresService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HEM6MC
 */


@Controller
@RequestMapping("/meres")
public class MeresController implements WebMvcConfigurer{
       private MeresService meresService;
       private DolgozoService dolgozoService;
       
           @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/meresresults").setViewName("meresresults");
    }
       
    @Autowired
    public void setMeresService(MeresService meresService) {
        this.meresService = meresService;

    }
    
    @Autowired
    public void setDolgozoService(DolgozoService dolgozoService){
        this.dolgozoService = dolgozoService;
    }
    
    @GetMapping("")
    public String showForm(MeresModel meresModel) {
        return "meresform";
    }
    
    
    
    
    
    
    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllMeres(){
        List<Meres> meresList = meresService.getAllMeres();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("mereslistform");
        mav.addObject("meresList", meresList);

        return mav;
    }
    
    
    
    @PostMapping("/list") 
    @ResponseBody
    public ModelAndView listDelete(@RequestParam("deleteId") Long deleteId) {
        meresService.deleteMeresById(deleteId);
        List<Meres> meresList = meresService.getAllMeres();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("mereslistform");
        mav.addObject("meresList", meresList);
        
        return mav;
    }
    
    
    
    
    
    
    
    
    @PostMapping("")
    public String saveMeres(@RequestParam("editId") Long editId, @Valid MeresModel meresModel, BindingResult bindingResult, RedirectAttributes ra){

        if(bindingResult.hasErrors()){
            return "meresform";
        }
        
        if(dolgozoService.dolgozoExistsById(editId) == false){
        return "meresform";
        }
        
        Dolgozo dolgozo;
        dolgozo = dolgozoService.getDolgozoById(editId);

        Date d = new Date();
       
        Meres meres = new Meres(dolgozo);
        meres.setAlkatreszszam(meresModel.getAlkatreszszam());
        meres.setHossz(meresModel.getHossz());
        meres.setSuly(meresModel.getSuly());
        meres.setIdopont(d);
        meres.setDolgozo(dolgozo);
        
        
        

        System.out.println(meresModel.toString());

        meresService.addMeres(meres);
        ra.addFlashAttribute("newMeres", meres);
        return "redirect:/meresresults";
       
    }
    
    
    /* Lecserelve a listas torlesre!
    
     @GetMapping("/delete")
    public String showDeleteForm() {
        return "meresdeleteform";
    }
    
    
      @PostMapping("/delete") 
     public ModelAndView deleteMeres(@RequestParam("deleteId") Long deleteId) {
     if(meresService.meresExistsById(deleteId) == false){
     ModelAndView univerMessage = new ModelAndView();
     univerMessage.setViewName("univerMessageForm");
     String uzenet = "A(z) " + deleteId + ". sorszamu (ID) meres nem letezik!";
     univerMessage.addObject("uzenet", uzenet);
     return univerMessage;
     }
         
   
     meresService.deleteMeresById(deleteId);
     
     ModelAndView univerMessage = new ModelAndView();
     univerMessage.setViewName("univerMessageForm");
     String uzenet = "A(z) " + deleteId + ". sorszamu (ID) meres sikeresen torlesre kerult!";
     univerMessage.addObject("uzenet", uzenet);
     return univerMessage;
        
     }
     
    */
    
    
    
    
    
}
