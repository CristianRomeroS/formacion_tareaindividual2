package com.formacionspring.app.apirestindividual.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String dni;
	private String nombre;
	private double salario;
	private int telefono;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="departamento_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Departamento departamento;
	
	
	
	
	
	public long getId() {
		return id;
	}





	public String getDni() {
		return dni;
	}





	public String getNombre() {
		return nombre;
	}





	public double getSalario() {
		return salario;
	}





	public int getTelefono() {
		return telefono;
	}





	public Departamento getDepartamento() {
		return departamento;
	}





	public void setId(long id) {
		this.id = id;
	}





	public void setDni(String dni) {
		this.dni = dni;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public void setSalario(double salario) {
		this.salario = salario;
	}





	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}





	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
