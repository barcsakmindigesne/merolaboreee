/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers;

import com.webalk.merolabor.controllers.model.EszkozModel;
import com.webalk.merolabor.entity.Dolgozo;
import com.webalk.merolabor.entity.Eszkoz;
import com.webalk.merolabor.services.DolgozoService;
import com.webalk.merolabor.services.EszkozService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HEM6MC
 */

@Controller
@RequestMapping("/eszkozok")
public class EszkozController implements WebMvcConfigurer {

    private DolgozoService dolgozoService;
    private EszkozService eszkozService;

    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/eszkozresults").setViewName("eszkozresults");
        registry.addViewController("/eszkozjogosultsagresults").setViewName("eszkozjogosultsagresults");
    }
    
    
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
    ModelAndView getAllEszkoz() {
        List<Eszkoz> eszkozList = eszkozService.getAllEszkoz();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("eszkozlistform");
        mav.addObject("eszkozList", eszkozList);

        return mav;
    }
    
    @PostMapping("/list")
    @ResponseBody
    public ModelAndView listDelete(@RequestParam("deleteId") Long deleteId) {
        
        if(eszkozService.eszkozExistsById(deleteId) == false || deleteId == null){
        throw new IllegalArgumentException("Hiba tortent, a torolni kivant eszkoz nem letezik!");
        }

        Eszkoz eszkoz;
        eszkoz = eszkozService.getEszkozById(deleteId);
        
        dolgozoService.removeThisEszkozFromDolgozok(eszkoz);
        eszkozService.deleteEszkozById(deleteId);

        List<Eszkoz> eszkozList = eszkozService.getAllEszkoz();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("eszkozlistform");
        mav.addObject("eszkozList", eszkozList);

        return mav;
    }
    
    
    
    
    
    
    
    

    @GetMapping("/{id}")
    public String showForm(@PathVariable(value = "id") Long id, Model model) {
        
        if(eszkozService.eszkozExistsById(id) == false || id == null){
        throw new IllegalArgumentException("Valami hiba tortent! Nem letezik eszkoz ilyen id-val.");
        }
        
        Eszkoz eszkoz;
        eszkoz = eszkozService.getEszkozById(id);

        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozoWithoutThisEszkoz(eszkoz);
        
        if(dolgozoList.isEmpty() == true){
        model.addAttribute("uresuzenet", "A lista ures, mert mar az osszes dolgozo hozza van adva, igy jogosultsagot sem tudsz hozzaadni!");
        }
        
        
        model.addAttribute("dolgozoList", dolgozoList);

      
        return "eszkozform";
    }

    @PostMapping("/{id}")
    public String postForm(@PathVariable(value = "id") Long id, @RequestParam(value = "editId", required=false) Long editId, RedirectAttributes ra) {

        if (editId == null || dolgozoService.dolgozoExistsById(editId) == false) {
            throw new IllegalArgumentException("Nem kerult felhasznalo megadasra, vagy a megadott id nem letezik.");
        }
        
        if(eszkozService.eszkozExistsById(id) == false || id == null){
        throw new IllegalArgumentException("Valami hiba tortent! Nem letezik eszkoz ilyen id-val.");
        }

        Eszkoz eszkoz;
        eszkoz = eszkozService.getEszkozById(id);
        Dolgozo dolgozo;
        dolgozo = dolgozoService.getDolgozoById(editId);

        eszkoz.getDolgozoList().add(dolgozo);
        eszkozService.addEszkoz(eszkoz);

        
        ra.addFlashAttribute("eszkoznev", eszkoz.getEszkoznev());
         ra.addFlashAttribute("modositas", "jog hozzaadas");
          ra.addFlashAttribute("dolgozonev", dolgozo.getNev());
        return "redirect:/eszkozjogosultsagresults";
        
        //return "eszkozlistform";

    }
    
    
    @GetMapping("/dolgozoremove/{id}")
    public String showDolgozoRemoveForm(@PathVariable(value = "id") Long id, Model model) {

        if(eszkozService.eszkozExistsById(id) == false || id == null){
        throw new IllegalArgumentException("Valami hiba tortent! Nem letezik eszkoz ilyen id-val.");
        }
        
        Eszkoz eszkoz;
        eszkoz = eszkozService.getEszkozById(id);

        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozoWithThisEszkoz(eszkoz);

        
        
        if(dolgozoList.isEmpty() == true){
        model.addAttribute("uresuzenet", "A lista ures, mert az eszkozhoz egyetlen dolgozo sincs beallitva, igy jogosultsagot sem tudsz elvenni!");
        }
        
        
        model.addAttribute("dolgozoList", dolgozoList);

      

       
        return "eszkozdolgozoremoveform";
    }

    
    
    
    
    @PostMapping("/dolgozoremove/{id}")
    public String postDolgozoRemoveForm(@PathVariable(value = "id") Long id, @RequestParam("editId") Long editId, RedirectAttributes ra) {

    if(eszkozService.eszkozExistsById(id) == false || id == null){
        throw new IllegalArgumentException("Valami hiba tortent! Nem letezik eszkoz ilyen id-val.");
    }    
        
        
    if (editId == null || dolgozoService.dolgozoExistsById(editId) == false) {
            throw new IllegalArgumentException("Nem kerult felhasznalo megadasra, vagy a megadott id nem letezik.");
    }

        Eszkoz eszkoz;
        eszkoz = eszkozService.getEszkozById(id);
        Dolgozo dolgozo;
        dolgozo = dolgozoService.getDolgozoById(editId);

        eszkoz.getDolgozoList().remove(dolgozo);
        eszkozService.addEszkoz(eszkoz);

       
        
        ra.addFlashAttribute("eszkoznev", eszkoz.getEszkoznev());
         ra.addFlashAttribute("modositas", "jog elvetel");
          ra.addFlashAttribute("dolgozonev", dolgozo.getNev());
        return "redirect:/eszkozjogosultsagresults";
        
        
       // return "eszkozlistform";

    }
    
    @GetMapping("/add")
    public String showForm(EszkozModel eszkozModel) {
        return "eszkozaddform";
    }
    
    @PostMapping("/add")
    public String saveDolgozo(@Valid EszkozModel eszkozModel, BindingResult bindingResult, RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {
            return "eszkozaddform";
        }

        Eszkoz eszkoz = new Eszkoz();

      
        eszkoz.setEszkoznev(eszkozModel.getEszkoznev());

        System.out.println(eszkozModel.toString());

        eszkozService.addEszkoz(eszkoz);
        ra.addFlashAttribute("newEszkoz", eszkozModel);
        return "redirect:/eszkozresults";
       
    }
    
    
    
    
}
