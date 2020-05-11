package com.example.CRUD.converters;

import org.springframework.stereotype.Component;

import com.example.CRUD.entities.Skill;
import com.example.CRUD.models.SkillModel;

@Component("skillConverter")
public class SkillConverter {

	public SkillModel EntityToModel(Skill skill) {
		return new SkillModel(skill.getIdSkill(),skill.getName());
	}
	
	public Skill ModelToEntity(SkillModel skillModel) {
		return new Skill(skillModel.getIdSkill(),skillModel.getName());
	}


}
