package com.example.CRUD.services;

import java.util.List;

import com.example.CRUD.entities.Develop;
import com.example.CRUD.models.DevelopModel;

public interface IDevelopService {
	
	public List<Develop> getAll();
	
	public DevelopModel insertOrUpdate(DevelopModel developModel);
	
	public boolean remove(long idDevelop);
	
	public Develop findByIdDevelop(long idDevelop);

}
