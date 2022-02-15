package com.formacionspring.app.apirestindividual.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspring.app.apirestindividual.entity.Jefe;
import com.formacionspring.app.apirestindividual.service.JefeService;

@RestController
@RequestMapping("/app")
public class JefeController {
	@Autowired
	private JefeService servicio;
	
	@GetMapping("Jefes")
	public List<Jefe> jefes(){
		return servicio.findAll();
	}
	
	@GetMapping("Jefes/{id}")
	public ResponseEntity<?> jefe(@PathVariable Long id){
		Jefe jefe=null;
		Map<String,Object> response=new HashMap<>();
		
		try {
			jefe=servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(jefe==null) {
			response.put("mensaje", "El jefe ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<Jefe>(jefe,HttpStatus.OK);
	}
	
	@PostMapping("/Jefes")
	public ResponseEntity<?> save(@RequestBody Jefe jefe) {
		Jefe jefeNew=null;
		Map<String,Object> response=new HashMap<>();
		try {
			jefeNew=servicio.save(jefe);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insercion en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Jefe ha sido creado con exito");
		response.put("Jefe", jefeNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Jefes/{id}")
	public ResponseEntity<?> updateempleado( @RequestBody Jefe jefe, @PathVariable long id) {
		Jefe jefeNew=servicio.findById(id);
		Map<String,Object> response=new HashMap<>();
		try {
			jefeNew.setDni(jefe.getDni());
			jefeNew.setNombre(jefe.getNombre());
			jefeNew.setSalario(jefe.getSalario());
			jefeNew.setTelefono(jefe.getTelefono());
			jefeNew.setDepartamento(jefe.getDepartamento());
			servicio.save(jefeNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar modificacion en el jefe ");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El jefe ha sido modificado  con exito");
		response.put("jefe",jefeNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Jefes/{id}")
	public ResponseEntity<?> deleteCleinte(@PathVariable Long id) {
		Jefe jefeBorrado=null;
		
		Map<String,Object> response=new HashMap<>();
				
			jefeBorrado=servicio.findById(id);
			if(jefeBorrado==null) {
				response.put("mensaje", "El jefe con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

			}else {
				try {
					servicio.delete(id);
				} catch (DataAccessException e) {
					response.put("mensaje", "Error al borrar el jefe ");
					response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

		response.put("mensaje", "El jefe ha sido borrado con exito");
		response.put("jefe", jefeBorrado);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
}
