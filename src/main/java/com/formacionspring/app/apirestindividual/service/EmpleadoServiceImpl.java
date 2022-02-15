package com.formacionspring.app.apirestindividual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspring.app.apirestindividual.dao.EmpleadoDao;
import com.formacionspring.app.apirestindividual.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>)empleadoDao.findAll();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Empleado findById(long id) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	public Empleado save(Empleado empleados) {
		// TODO Auto-generated method stub
		return empleadoDao.save(empleados);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		empleadoDao.deleteById(id);
	}
	
}
