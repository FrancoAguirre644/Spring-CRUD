package com.example.CRUD.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.CRUD.converters.DevelopConverter;
import com.example.CRUD.entities.Develop;
import com.example.CRUD.models.DevelopModel;
import com.example.CRUD.repositories.IDevelopRepository;
import com.example.CRUD.services.IDevelopService;


@Service("developService")
public class DevelopService implements IDevelopService{	
	
	@Autowired
	@Qualifier("developRepository")
	private IDevelopRepository developRepository;
	
	@Autowired
	@Qualifier("developConverter")
	private DevelopConverter developConverter;

	@Override
	public List<Develop> getAll() {
		return developRepository.findAll();
	}

	@Override
	public DevelopModel insertOrUpdate(DevelopModel developModel) {
		Develop develop = developRepository.save(developConverter.ModelToEntity(developModel));
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
	public Develop findByIdDevelop(long idDevelop) {
		return developRepository.findByIdDevelop(idDevelop);
	}

}
