package com.formacionspring.app.apirestindividual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspring.app.apirestindividual.dao.JefeDao;
import com.formacionspring.app.apirestindividual.entity.Jefe;

@Service
public class JefeServiceImpl implements JefeService{
@Autowired
private JefeDao jefeDao;

@Override
public List<Jefe> findAll() {
	// TODO Auto-generated method stub
	return (List<Jefe>) jefeDao.findAll();
}

@Override
public Jefe findById(long id) {
	// TODO Auto-generated method stub
	return jefeDao.findById(id).orElse(null);
}

@Override
public Jefe save(Jefe jefe) {
	// TODO Auto-generated method stub
	return jefeDao.save(jefe);
}

@Override
public void delete(long id) {
	// TODO Auto-generated method stub
	jefeDao.deleteById(id);
}
}
