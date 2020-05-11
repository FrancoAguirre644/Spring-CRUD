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
import com.example.CRUD.models.SkillModel;
import com.example.CRUD.services.ISkillService;

@Controller
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	@Qualifier("skillService")
	private ISkillService skillService;
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SKILL_ADD);
		mAV.addObject("skill", new SkillModel());
		
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("skill") SkillModel skillModel) {
		skillService.insertOrUpdate(skillModel);
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	@GetMapping("{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SKILL_UPDATE);
		mAV.addObject("skill", skillService.findByIdSkill(id));
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("develop") SkillModel skillModel) {
		skillService.insertOrUpdate(skillModel);
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	@GetMapping("delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		
		skillService.remove(id);
		
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}
	
	

}
