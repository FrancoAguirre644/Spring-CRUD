package com.example.CRUD.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DeveloperModel {
	
	private long idDevelop;
	
	@NotEmpty
	private String name;
	
	@NotNull
    @Min(value = 16)
    @Max(value = 100)
	private int age;
	
	@NotEmpty
	private String adress;
	
	private SkillModel skill; 
	
	public DeveloperModel() {
		
	}

	public DeveloperModel(long idDevelop, String name, int age, String adress,SkillModel skill) {
		super();
		this.idDevelop = idDevelop;
		this.name = name;
		this.age = age;
		this.adress = adress;
		this.setSkill(skill);
	}

	public long getIdDevelop() {
		return idDevelop;
	}

	public void setIdDevelop(long idDevelop) {
		this.idDevelop = idDevelop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public SkillModel getSkill() {
		return skill;
	}

	public void setSkill(SkillModel skill) {
		this.skill = skill;
	}
	

}

