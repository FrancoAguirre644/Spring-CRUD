package com.example.CRUD.models;

public class DevelopModel {
	
	private long idDevelop;
	private String name;
	private int age;
	private String adress;
	private SkillModel skill; 
	
	public DevelopModel() {
		
	}

	public DevelopModel(long idDevelop, String name, int age, String adress,SkillModel skill) {
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

