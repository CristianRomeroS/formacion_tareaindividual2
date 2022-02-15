package com.formacionspring.app.apirestindividual.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.formacionspring.app.apirestindividual.dao.EmpleadosDao;
import com.formacionspring.app.apirestindividual.entity.Empleados;
@Service
public class EmpleadosServiceImpl implements EmpleadosService{
	@Autowired
	private EmpleadosDao empleadosDao;

	@Override
	public List<Empleados> findEmpleado() {
		// TODO Auto-generated method stub
		return (List<Empleados>) empleadosDao.findAll();
	}






}
