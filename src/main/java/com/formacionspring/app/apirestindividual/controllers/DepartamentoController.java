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

import com.formacionspring.app.apirestindividual.entity.Departamento;
import com.formacionspring.app.apirestindividual.service.DepartamentoService;


@RestController
@RequestMapping("/app")
public class DepartamentoController {

	@Autowired
	private DepartamentoService servicio;
	
	@GetMapping("/Departamentos")
	public List<Departamento> departamentos(){
		return servicio.findAll();
	}
	
	@GetMapping("/Departamentos/{id}")
	public ResponseEntity<?> Departamento(@PathVariable Long id){
		Departamento departamento=null;
		Map<String,Object> response=new HashMap<>();
		
		try {
			departamento=servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(departamento==null) {
			response.put("mensaje", "El Departamento con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<Departamento>(departamento,HttpStatus.OK);
	}
	
	@PostMapping("/Departamentos")
	public ResponseEntity<?> save(@RequestBody Departamento Departamento) {
		Departamento departamentoNew=null;
		Map<String,Object> response=new HashMap<>();
		try {
			departamentoNew=servicio.save(Departamento);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insercion en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Departamento ha sido creado con exito");
		response.put("Departamento", departamentoNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Departamentos/{id}")
	public ResponseEntity<?> updateDepartamentos( @RequestBody Departamento departamento, @PathVariable long id) {
		Departamento departamentoNew=servicio.findById(id);
		Map<String,Object> response=new HashMap<>();
		try {
			departamentoNew.setNombre(departamento.getNombre());
			departamentoNew.setUbicacion(departamento.getUbicacion());
			servicio.save(departamentoNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar modificacion en el departamento ");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El departamento ha sido modificado  con exito");
		response.put("departamento",departamentoNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Departamentos/{id}")
	public ResponseEntity<?> deleteCleinte(@PathVariable Long id) {
		Departamento departamentoBorrado=null;
		
		Map<String,Object> response=new HashMap<>();
				
			departamentoBorrado=servicio.findById(id);
			if(departamentoBorrado==null) {
				response.put("mensaje", "El Departamento con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

			}else {
				try {
					servicio.delete(id);
				} catch (DataAccessException e) {
					response.put("mensaje", "Error al borrar el Departamento ");
					response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

		response.put("mensaje", "El departamento ha sido borrado con exito");
		response.put("Departamento", departamentoBorrado);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
}
