package com.example.CRUD.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.CRUD.entities.Developer;
import com.example.CRUD.models.DeveloperModel;

@Component("developerConverter")
public class DeveloperConverter {
	
	@Autowired
	@Qualifier("skillConverter")
	private SkillConverter skillConverter;
	
	
	public DeveloperModel EntityToModel(Developer develop) {
		return new DeveloperModel(develop.getIdDevelop(),develop.getName(),develop.getAge(),develop.getAdress(),skillConverter.EntityToModel(develop.getSkill()));
	}
	
	public Developer ModelToEntity(DeveloperModel developModel) {
		return new Developer(developModel.getIdDevelop(),developModel.getName(),developModel.getAge(),developModel.getAdress(),skillConverter.ModelToEntity(developModel.getSkill()));
	}

}
