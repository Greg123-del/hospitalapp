package com.gregory.hospitalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.gregory.hospitalapp.dao.interfaces.*;
import com.gregory.hospitalapp.model.*;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacientesDao pacienteDao;
	
	
	@RequestMapping(value="/cadastrarPaciente", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) {
		
		pacienteDao.save(paciente);
		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/atenderPaciente", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> atender(@RequestBody int num_regi) {
		int pacienteModel = pacienteDao.updateAtender(num_regi);
		return new ResponseEntity<>(pacienteModel, HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/listarPaciente")
	public List<Paciente> listarPacientes() {
		List<Paciente> Pacientelist = (List<Paciente>) pacienteDao.findAllPaciente();
		return Pacientelist;
	}

}
