/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webalk.merolabor.controllers;

import com.webalk.merolabor.services.DolgozoService;
import com.webalk.merolabor.services.EszkozService;
import com.webalk.merolabor.services.MeresService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HEM6MC
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homeform() {

        return "homeform";
    }

    private DolgozoService dolgozoService;
    private MeresService meresService;
    private EszkozService eszkozService;

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

    @GetMapping("/statisztika")
    @ResponseBody
    ModelAndView getStatisztika() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("statisztika");
       
        
                
        mav.addObject("dolgozokszama", dolgozoService.getAllDolgozo().size());
        mav.addObject("dolgozokatlageletkora", dolgozoService.dolgozokAtlagEletkora());
        mav.addObject("meresekszama", meresService.getAllMeres().size());
        mav.addObject("atlaghossz", meresService.getAtlagHossz());
        mav.addObject("atlagsuly", meresService.getAtlagSuly());
        mav.addObject("eszkozokszama", eszkozService.getAllEszkoz().size());
        mav.addObject("lekerdezve", new Date());
        

        return mav;
    }

}
