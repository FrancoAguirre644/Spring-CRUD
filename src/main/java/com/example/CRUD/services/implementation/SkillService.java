package com.example.CRUD.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.CRUD.converters.SkillConverter;
import com.example.CRUD.entities.Skill;
import com.example.CRUD.models.SkillModel;
import com.example.CRUD.repositories.ISkillRepository;
import com.example.CRUD.services.ISkillService;

@Service("skillService")
public class SkillService implements ISkillService{
	
	@Autowired
	@Qualifier("skillRepository")
	private ISkillRepository skillRepository;
	
	@Autowired
	@Qualifier("skillConverter")
	private SkillConverter skillConverter;

	@Override
	public List<Skill> getAll() {
		return skillRepository.findAll();
	}

	@Override
	public SkillModel findByName(String name) {
		return skillConverter.EntityToModel(skillRepository.findByName(name));
	}

	@Override
	public SkillModel findByIdSkill(long idSkill) {
		return skillConverter.EntityToModel(skillRepository.findByIdSkill(idSkill));
	}
	
	@Override
	public SkillModel insertOrUpdate(SkillModel skillModel) {
		Skill skill = skillRepository.save(skillConverter.ModelToEntity(skillModel));
		return skillConverter.EntityToModel(skill);
	}
	
	@Override
	public boolean remove(long idSkill) {
		try {
			skillRepository.deleteById(idSkill);
			return true;
		}catch(Exception e) {
			return false;
		}	
	}
	
}
	


