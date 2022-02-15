package com.formacionspring.app.apirestindividual.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspring.app.apirestindividual.entity.Empleados;
import com.formacionspring.app.apirestindividual.service.EmpleadosService;

@RestController
@RequestMapping("/app")
public class EmpleadosController {
	
	@Autowired 
	private EmpleadosService servicio;
	@PostMapping("/login")
	public ResponseEntity<?> empleados(@RequestBody Empleados empleados){
		List<Empleados> empleados2 = new ArrayList<Empleados>();
		empleados2=servicio.findEmpleado();
		Map<String,Object> response=new HashMap<>();
		String dni= empleados.getDni();
		String contraseña=empleados.getContraseña();
		boolean t=false,r=false;
		String mensaje="";
		for(Empleados emp:empleados2) {
			if(emp.getDni().equals(dni)) {
				r=true;
				if(emp.getContraseña().equals(contraseña)) {
					t=true;
				}
			}
			
			if(emp.getContraseña().equals(contraseña)) {
				t=true;
				if(emp.getDni().equals(dni)) {
					r=true;
				}
			}
			
	
		}
		if(!t&&!r) {
			response.put("mensaje", "Usuario y contraseña erroneos");
		}else if(!t&&r){
			response.put("mensaje", "contraseña incorrecta");
		}else if(!r&&t){
			response.put("mensaje", "Usuario incorrecta");
		}else {
			response.put("mensaje", "Usuario logueado");
			response.put("Login",empleados);
		}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	 @GetMapping("/all")
	public List<Empleados> empleados(){
		return servicio.findEmpleado();
	}
}
