package com.formacionspring.app.apirestindividual.service;

import java.util.List;

import com.formacionspring.app.apirestindividual.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();
	public Empleado findById(long id);
	public Empleado save(Empleado empleados);
	public void delete(long id);
}
