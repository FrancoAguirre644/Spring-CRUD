package com.example.CRUD.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.CRUD.entities.Develop;
import com.example.CRUD.models.DevelopModel;

@Component("developConverter")
public class DevelopConverter {
	
	@Autowired
	@Qualifier("skillConverter")
	private SkillConverter skillConverter;
	
	
	public DevelopModel EntityToModel(Develop develop) {
		return new DevelopModel(develop.getIdDevelop(),develop.getName(),develop.getAge(),develop.getAdress(),skillConverter.EntityToModel(develop.getSkill()));
	}
	
	public Develop ModelToEntity(DevelopModel developModel) {
		return new Develop(developModel.getIdDevelop(),developModel.getName(),developModel.getAge(),developModel.getAdress(),skillConverter.ModelToEntity(developModel.getSkill()));
	}

}
