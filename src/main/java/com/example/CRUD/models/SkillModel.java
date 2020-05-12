package com.example.CRUD.models;

import javax.validation.constraints.NotEmpty;

public class SkillModel {
	
	private long idSkill;
	@NotEmpty
	private String name;
	
	public SkillModel() {
		
	}
	

	public SkillModel(long idSkill, String name) {
		super();
		this.idSkill = idSkill;
		this.name = name;
	}


	public long getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(long idSkill) {
		this.idSkill = idSkill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
