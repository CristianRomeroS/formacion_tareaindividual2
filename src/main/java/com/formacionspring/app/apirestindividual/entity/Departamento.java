package com.formacionspring.app.apirestindividual.entity;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="departamentos")
public class Departamento implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String ubicacion;
	
	
	
	public long getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	public String getUbicacion() {
		return ubicacion;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}