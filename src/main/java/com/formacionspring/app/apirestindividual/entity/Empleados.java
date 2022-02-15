package com.formacionspring.app.apirestindividual.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Empleados implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String dni;
	@Column(nullable=false)
	private String contraseña;
	
	
	public long getId() {
		return id;
	}



	public String getDni() {
		return dni;
	}



	public String getContraseña() {
		return contraseña;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
}
