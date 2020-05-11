package com.example.CRUD.services;

import java.util.List;

import com.example.CRUD.entities.Skill;
import com.example.CRUD.models.SkillModel;

public interface ISkillService {
	
	public List<Skill> getAll();
	
	public SkillModel findByName(String name);
	
	public SkillModel findByIdSkill(long idSkill);
	
	public SkillModel insertOrUpdate(SkillModel skillModel);
	
	public boolean remove(long idSkill);

}
