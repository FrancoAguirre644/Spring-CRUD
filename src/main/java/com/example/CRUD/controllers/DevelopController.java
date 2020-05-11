package com.example.CRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.CRUD.helpers.ViewRouteHelpers;
import com.example.CRUD.models.DevelopModel;
import com.example.CRUD.services.IDevelopService;
import com.example.CRUD.services.ISkillService;

@Controller
@RequestMapping("/crud")
public class DevelopController {
	
	@Autowired
	@Qualifier("developService")
	private IDevelopService developService;
	
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
		mAV.addObject("develop", new DevelopModel());
		
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("develop") DevelopModel developModel) {
		developService.insertOrUpdate(developModel);
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	@GetMapping("{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.DEVELOP_UPDATE);
		mAV.addObject("develop", developService.findByIdDevelop(id));
		mAV.addObject("skills", skillService.getAll());
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("develop") DevelopModel developModel) {
		developModel.setSkill(skillService.findByIdSkill(developModel.getSkill().getIdSkill()));
		developService.insertOrUpdate(developModel);
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	@GetMapping("delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		
		developService.remove(id);
		
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	

}
