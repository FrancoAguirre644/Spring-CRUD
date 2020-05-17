package com.example.CRUD.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.entities.Skill;

@Repository("skillRepository")
public interface ISkillRepository extends JpaRepository<Skill, Serializable>{
	
	public abstract Skill findByName(String name);
	public abstract Skill findByIdSkill(long idSkill);

}
