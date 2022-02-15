package com.formacionspring.app.apirestindividual.service;

import java.util.List;

import com.formacionspring.app.apirestindividual.entity.Departamento;



public interface DepartamentoService {
	
	public List<Departamento> findAll();
	public Departamento findById(long id);
	public Departamento save(Departamento departamento);
	public void delete(long id);
}
