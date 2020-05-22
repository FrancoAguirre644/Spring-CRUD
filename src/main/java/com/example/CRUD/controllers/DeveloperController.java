package com.example.CRUD.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.CRUD.helpers.ViewRouteHelpers;
import com.example.CRUD.models.DeveloperModel;
import com.example.CRUD.services.IDeveloperService;
import com.example.CRUD.services.ISkillService;

@Controller
@RequestMapping("/crud")
public class DeveloperController {
	
	@Autowired
	@Qualifier("developerService")
	private IDeveloperService developService;
	
	@Autowired
	@Qualifier("skillService")
	private ISkillService skillService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelpers.INDEX);
		mAV.addObject("developers", developService.getAll());
		mAV.addObject("skills", skillService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.DEVELOP_ADD);
		mAV.addObject("skills", skillService.getAll());
		mAV.addObject("develop", new DeveloperModel());
		
		return mAV;
	}
	
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("develop") DeveloperModel developModel, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		ModelAndView mV = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.DEVELOP_ADD);
			mV.addObject("skills", skillService.getAll());

		}else {
			developService.insertOrUpdate(developModel);
			mV.setViewName("redirect:"+ViewRouteHelpers.REDIRECT_VIEW);
			redirectAttrs.addFlashAttribute("mensaje","Agregado Correctamente");
			redirectAttrs.addFlashAttribute("clase", "success");
		}
		
		return mV;
	}
	
	@GetMapping("{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.DEVELOP_UPDATE);
		mAV.addObject("develop", developService.findByIdDevelop(id));
		mAV.addObject("skills", skillService.getAll());
		return mAV;
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("develop") DeveloperModel developModel, BindingResult bindingResult,RedirectAttributes redirectAttrs) {
		ModelAndView mV = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.DEVELOP_UPDATE);
			mV.addObject("skills", skillService.getAll());
		}else {
			developModel.setSkill(skillService.findByIdSkill(developModel.getSkill().getIdSkill()));
			developService.insertOrUpdate(developModel);
			redirectAttrs.addFlashAttribute("mensaje","Actualizado Correctamente");
			redirectAttrs.addFlashAttribute("clase", "success");
			mV.setViewName("redirect:"+ViewRouteHelpers.REDIRECT_VIEW);
		}			
		
		return mV;
	}
	
	@GetMapping("delete/{id}")
	public RedirectView delete(@PathVariable("id") long id,RedirectAttributes redirectAttrs) {
		
		developService.remove(id);
		redirectAttrs.addFlashAttribute("mensaje","Eliminado Correctamente");
		redirectAttrs.addFlashAttribute("clase", "success");
		
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	

}
