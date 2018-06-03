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
import com.webalk.merolabor.services.EszkozService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/dolgozo")
public class DolgozoController implements WebMvcConfigurer {

    private DolgozoService dolgozoService;
    private MeresService meresService;
    private EszkozService eszkozService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
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
    
    @Autowired
    public void setEszkozService(EszkozService eszkozService) {
        this.eszkozService = eszkozService;
    }

    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllDolgozo() {
        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozo();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("dolgozolistform");
        mav.addObject("dolgozoList", dolgozoList);

        return mav;
    }

    @PostMapping("/list")
    @ResponseBody
    public ModelAndView listDelete(@RequestParam("deleteId") Long deleteId) {
        
        if(dolgozoService.dolgozoExistsById(deleteId) == false || deleteId == null){
        throw new IllegalArgumentException("Hiba tortent, a torolni kivant dolgozo nem letezik!");
        }

        Dolgozo dolgozo;
        dolgozo = dolgozoService.getDolgozoById(deleteId);
        meresService.deleteAllMeresByDolgozo(dolgozo);
        eszkozService.getAllEszkozAndRemoveDolgozo(dolgozo);
        dolgozoService.deleteDolgozoById(deleteId);

        List<Dolgozo> dolgozoList = dolgozoService.getAllDolgozo();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("dolgozolistform");
        mav.addObject("dolgozoList", dolgozoList);

        return mav;
    }



    @GetMapping("")
    public String showForm(DolgozoModel dolgozoModel) {
        return "dolgozoform";
    }

    
    @PostMapping("")
    public String saveDolgozo(@Valid DolgozoModel dolgozoModel, BindingResult bindingResult, RedirectAttributes ra) {

        
   
        if (bindingResult.hasErrors()) {  
            return "dolgozoform";
        }
 

        Dolgozo dolgozo = new Dolgozo();
        dolgozo.setEletkor(dolgozoModel.getEletkor());
        dolgozo.setNev(dolgozoModel.getNev());

        System.out.println(dolgozoModel.toString());
        dolgozoService.addDolgozo(dolgozo);
        ra.addFlashAttribute("newDolgozo", dolgozoModel);

        return "redirect:/dolgozoresults";
        
    }
    

}
