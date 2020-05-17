package com.example.CRUD.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.entities.Developer;

@Repository("developerRepository")
public interface IDeveloperRepository extends JpaRepository<Developer, Serializable>{
	
	public abstract Developer findByIdDevelop(long idDevelop);
}
