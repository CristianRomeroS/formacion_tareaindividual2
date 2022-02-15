package com.formacionspring.app.apirestindividual.dao;




import org.springframework.data.repository.CrudRepository;


import com.formacionspring.app.apirestindividual.entity.Empleado;

public interface EmpleadoDao extends CrudRepository<Empleado, Long>{
}
