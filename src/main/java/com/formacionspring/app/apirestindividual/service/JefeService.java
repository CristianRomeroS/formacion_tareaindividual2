package com.formacionspring.app.apirestindividual.service;

import java.util.List;

import com.formacionspring.app.apirestindividual.entity.Jefe;

public interface JefeService {

	public List<Jefe> findAll();
	public Jefe findById(long id);
	public Jefe save(Jefe jefe);
	public void delete(long id);
}
