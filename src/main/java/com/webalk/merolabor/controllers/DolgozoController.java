/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers;
import java.util.List;

import com.webalk.merolabor.controllers.model.DolgozoModel;
import com.webalk.merolabor.services.DolgozoService;
import com.webalk.merolabor.services.MeresService;
import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Meres;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/dolgozo")
public class DolgozoController implements WebMvcConfigurer{
    private DolgozoService dolgozoService;
     private MeresService meresService;
    
        @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/dolgozoresults").setViewName("dolgozoresults");
    }
    
    @Autowired
    public void setDolgozoService(DolgozoService dolgozoService) {
        this.dolgozoService = dolgozoService;

    }
    
     @Autowired
    public void setMeresService(MeresService meresService) {
        this.meresService = meresService;

    }
    
    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllDolgozo(){
        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozo();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("dolgozolistform");
        mav.addObject("dolgozoList", dolgozoList);
        
        return mav;
    }
    
    
    
    @PostMapping("/list") 
    @ResponseBody
    public ModelAndView listDelete(@RequestParam("deleteId") Long deleteId) {
       
             Dolgozo dolgozo;
     dolgozo = dolgozoService.getDolgozoById(deleteId);
     meresService.deleteAllMeresByDolgozo(dolgozo);
     dolgozoService.deleteDolgozoById(deleteId);
        
        
        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozo();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("dolgozolistform");
        mav.addObject("dolgozoList", dolgozoList);
        
        return mav;
    }
    
    
    
    
    
    
    /* !!! Lecserelve a listabol torlesre !!!
    
    @GetMapping("/delete")
    public String showDeleteForm() {
        return "dolgozodeleteform";
    }
    
     @PostMapping("/delete") 
     public ModelAndView deleteDolgozo(@RequestParam("deleteId") Long deleteId) {
     if(dolgozoService.dolgozoExistsById(deleteId) == false){
     ModelAndView univerMessage = new ModelAndView();
     univerMessage.setViewName("univerMessageForm");
     String uzenet = "A(z) " + deleteId + ". sorszamu (ID) felhasznalo nem letezik!";
     univerMessage.addObject("uzenet", uzenet);
     return univerMessage;
     }
         
     
     Dolgozo dolgozo;
     dolgozo = dolgozoService.getDolgozoById(deleteId);
     meresService.deleteAllMeresByDolgozo(dolgozo);
     dolgozoService.deleteDolgozoById(deleteId);
     
     ModelAndView univerMessage = new ModelAndView();
     univerMessage.setViewName("univerMessageForm");
     String uzenet = "A(z) " + deleteId + ". sorszamu (ID) felhasznalo es a hozza tartozo meresek sikeresen torlesre kerultek!";
     univerMessage.addObject("uzenet", uzenet);
     return univerMessage;
        
     }
     
     */
     
     @GetMapping("/dolgozok/{id}")
     public ModelAndView editDolgozoById(@PathVariable(value="id") Long id) throws Exception {
         
         /*
         if (id == null)
             throw new Exception("Nincs dolgozo ilyen ID-vel!");
             return "dolgozoeditform";
         */
           if(dolgozoService.dolgozoExistsById(id) == false){
            throw new Exception("Nincs dolgozo ilyen ID-vel!");
           }
         
     
            Dolgozo dolgozo;
            dolgozo = dolgozoService.getDolgozoById(id);
             ModelAndView mav = new ModelAndView();
             mav.setViewName("dolgozoeditform");
             mav.addObject(dolgozo);
             mav.addObject("id",id);
             return mav;
         

      }
     
     
      
        @PostMapping("/dolgozok/{id}")
         public ModelAndView editDolgozoById(@RequestParam("editId") Long editId, @Valid DolgozoModel dolgozoModel, BindingResult bindingResult, RedirectAttributes ra) {
         if(bindingResult.hasErrors()){
        /*
             Dolgozo dolgozo;
             dolgozo = dolgozoService.getDolgozoById(editId);
             ModelAndView mav = new ModelAndView();
             mav.setViewName("dolgozoeditform");
             mav.addObject(dolgozo);
             mav.addObject("id",editId);
             mav.addAllObjects(bindingResult.getModel());
             return mav;
          */   
              return new ModelAndView("redirect:/dolgozo/dolgozok/{id}");
         
        }

          Dolgozo dolgozo = dolgozoService.getDolgozoById(editId);
          
        dolgozo.setEletkor(dolgozoModel.getEletkor());
        dolgozo.setNev(dolgozoModel.getNev());
        
          dolgozoService.addDolgozo(dolgozo);
          
           ModelAndView mav = new ModelAndView();
             mav.setViewName("homeform");
       
             return mav;
          
          
         }
        
        
     
     
     /*
        @PostMapping("/dolgozok/{id}")
         public ModelAndView editDolgozoById(@RequestParam("editId") Long editId, @Valid DolgozoModel dolgozoModel, BindingResult bindingResult, RedirectAttributes ra) {
         if(bindingResult.hasErrors()){
        
              Dolgozo dolgozo;
            dolgozo = dolgozoService.getDolgozoById(editId);
             ModelAndView mav = new ModelAndView();
             mav.setViewName("dolgozoeditform");
             mav.addObject(dolgozo);
             mav.addObject("id",editId);
             return mav;
         
        }

          Dolgozo dolgozo = dolgozoService.getDolgozoById(editId);
          
        dolgozo.setEletkor(dolgozoModel.getEletkor());
        dolgozo.setNev(dolgozoModel.getNev());
        
          dolgozoService.addDolgozo(dolgozo);
          
           ModelAndView mav = new ModelAndView();
             mav.setViewName("homeform");
       
             return mav;
          
          
         }
        
        */
        
        
 
     

    
    @GetMapping("")
    public String showForm(DolgozoModel dolgozoModel) {
        return "dolgozoform";
    }
    
     @PostMapping("")
    public String saveDolgozo(@Valid DolgozoModel dolgozoModel, BindingResult bindingResult, RedirectAttributes ra){

        if(bindingResult.hasErrors()){
            return "dolgozoform";
        }

        Dolgozo dolgozo = new Dolgozo();
 
        
        dolgozo.setEletkor(dolgozoModel.getEletkor());
        dolgozo.setNev(dolgozoModel.getNev());

        System.out.println(dolgozoModel.toString());

        dolgozoService.addDolgozo(dolgozo);
        ra.addFlashAttribute("newDolgozo", dolgozoModel);
        return "redirect:/dolgozoresults";
       // return "dolgozoform";
    }
    
    
    
    
    
    

}
