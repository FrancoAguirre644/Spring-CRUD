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
import org.springframework.web.servlet.view.RedirectView;

import com.example.CRUD.entities.Developer;
import com.example.CRUD.helpers.ViewRouteHelpers;
import com.example.CRUD.models.SkillModel;
import com.example.CRUD.services.IDeveloperService;
import com.example.CRUD.services.ISkillService;

@Controller
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	@Qualifier("skillService")
	private ISkillService skillService;
	
	@Autowired
	@Qualifier("developerService")
	private IDeveloperService developerService;
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SKILL_ADD);
		mAV.addObject("skill", new SkillModel());
		
		return mAV;
	}
	
	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("skill") SkillModel skillModel, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.SKILL_ADD);

		}else {
			skillService.insertOrUpdate(skillModel);
			mV.setViewName("redirect:"+ViewRouteHelpers.REDIRECT_VIEW);
		}	
			
		return mV;
	}
	
	@GetMapping("{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SKILL_UPDATE);
		mAV.addObject("skill", skillService.findByIdSkill(id));
		return mAV;
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("skill") SkillModel skillModel, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.SKILL_UPDATE);

		}else {
			skillService.insertOrUpdate(skillModel);
			mV.setViewName("redirect:"+ViewRouteHelpers.REDIRECT_VIEW);
		}	
			
		return mV;
	}
	
	@GetMapping("delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		boolean band = false;
		int i=0;
				
		while(i<developerService.getAll().size() && !band) {
			Developer d = developerService.getAll().get(i);
			if(d.getSkill().getIdSkill() == id) {
				band = true;
			}
			
			i++;
		}
		
		if(!band) {
			skillService.remove(id);
		}
		
		
		return new RedirectView(ViewRouteHelpers.REDIRECT_VIEW);
	}

}
