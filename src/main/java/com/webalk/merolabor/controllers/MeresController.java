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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/meres")
public class MeresController implements WebMvcConfigurer {

    private MeresService meresService;
    private DolgozoService dolgozoService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/meresresults").setViewName("meresresults");
    }

    @Autowired
    public void setMeresService(MeresService meresService) {
        this.meresService = meresService;

    }

    @Autowired
    public void setDolgozoService(DolgozoService dolgozoService) {
        this.dolgozoService = dolgozoService;
    }

    @GetMapping("/{id}")
    public String showForm(@PathVariable(value = "id") Long id, Model model) {

        if (!model.containsAttribute("meresModel")) {
            model.addAttribute("meresModel", new MeresModel());
        }
        
        if (id == null || dolgozoService.dolgozoExistsById(id) == false) {
            throw new IllegalArgumentException("Hiba! Nem letezo dolgozo.");
        }
        

        Dolgozo dolgozo;
        dolgozo = dolgozoService.getDolgozoById(id);

        //return mav;
        return "meresform";
    }

    @PostMapping("/{id}")
    public String postMeres(@RequestParam("editId") Long editId, @Valid MeresModel meresModel, BindingResult bindingResult, RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {

            ra.addFlashAttribute("org.springframework.validation.BindingResult.meresModel", bindingResult);
            ra.addFlashAttribute("meresModel", meresModel);

            return "redirect:/meres/{id}";

        }

        if (editId == null || dolgozoService.dolgozoExistsById(editId) == false) {
            throw new IllegalArgumentException("Hiba! Nem letezo dolgozo.");
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

    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllMeres() {
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

}
