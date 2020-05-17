package com.example.CRUD.services;

import java.util.List;

import com.example.CRUD.entities.Developer;
import com.example.CRUD.models.DeveloperModel;

public interface IDeveloperService {
	
	public List<Developer> getAll();
	
	public DeveloperModel insertOrUpdate(DeveloperModel developModel);
	
	public boolean remove(long idDevelop);
	
	public Developer findByIdDevelop(long idDevelop);

}
