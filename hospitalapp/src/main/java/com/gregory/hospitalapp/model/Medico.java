package com.gregory.hospitalapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public class Medico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID_MEDICO;
	
	
	private String nome;
	private int num_regi;
	private int qtdAtend;
	
	
	
	public long getID_MEDICO() {
		return ID_MEDICO;
	}
	public void setID_MEDICO(int iD_MEDICO) {
		this.ID_MEDICO = iD_MEDICO;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNum_regi() {
		return num_regi;
	}
	public void setNum_regi(int num_regi) {
		this.num_regi = num_regi;
	}
	
	public int getQtdAtend() {
		return qtdAtend;
	}
	public void setQtdAtend(int qtdAtend) {
		this.qtdAtend = qtdAtend;
	}
	
	public String toString() {
		return getID_MEDICO() + " " + getNome();
	}

}
