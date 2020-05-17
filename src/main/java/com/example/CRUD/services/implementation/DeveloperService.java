package com.example.CRUD.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.CRUD.converters.DeveloperConverter;
import com.example.CRUD.entities.Developer;
import com.example.CRUD.models.DeveloperModel;
import com.example.CRUD.repositories.IDeveloperRepository;
import com.example.CRUD.services.IDeveloperService;


@Service("developerService")
public class DeveloperService implements IDeveloperService{	
	
	@Autowired
	@Qualifier("developerRepository")
	private IDeveloperRepository developRepository;
	
	@Autowired
	@Qualifier("developerConverter")
	private DeveloperConverter developConverter;

	@Override
	public List<Developer> getAll() {
		return developRepository.findAll();
	}

	@Override
	public DeveloperModel insertOrUpdate(DeveloperModel developModel) {
		Developer develop = developRepository.save(developConverter.ModelToEntity(developModel));
		return developConverter.EntityToModel(develop);
	}

	@Override
	public boolean remove(long idDevelop) {
		try {
			developRepository.deleteById(idDevelop);
			return true;
		}catch(Exception e) {
			return false;
		}	
	}

	@Override
	public Developer findByIdDevelop(long idDevelop) {
		return developRepository.findByIdDevelop(idDevelop);
	}

}
