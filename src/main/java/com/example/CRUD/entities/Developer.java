package com.example.CRUD.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="developer")
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDevelop;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
		
	@Column(name="adress")
	private String adress;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Skill skill;
	
	public Developer() {
		
	}

	public Developer(long idDevelop, String name, int age, String adress, Skill skill) {
		super();
		this.idDevelop = idDevelop;
		this.name = name;
		this.age = age;
		this.adress = adress;
		this.skill = skill;
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

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	

}
