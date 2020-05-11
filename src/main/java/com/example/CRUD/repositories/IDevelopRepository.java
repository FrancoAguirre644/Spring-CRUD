package com.example.CRUD.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.entities.Develop;

@Repository("developRepository")
public interface IDevelopRepository extends JpaRepository<Develop, Serializable>{
	
	public abstract Develop findByIdDevelop(long idDevelop);
}
