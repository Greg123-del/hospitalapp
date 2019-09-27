package com.gregory.hospitalapp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID_PACIENTE;
	
	
	private String name;
	private int age;
	private Double temperature;
	private int glicose;
	private int ID_MEDICO;
	
	
	public long getID_PACIENTE() {
		return ID_PACIENTE;
	}
	public void setID_PACIENTE(int iD_PACIENTE) {
		this.ID_PACIENTE = iD_PACIENTE;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public int getGlicose() {
		return glicose;
	}
	public void setGlicose(int glicose) {
		this.glicose = glicose;
	}
	
	public int getID_MEDICO() {
		return ID_MEDICO;
	}
	public void setID_MEDICO(int iD_MEDICO) {
		this.ID_MEDICO = iD_MEDICO;
	}
	public String toString() {
		return getID_PACIENTE() + " " + getName();
	}

}
