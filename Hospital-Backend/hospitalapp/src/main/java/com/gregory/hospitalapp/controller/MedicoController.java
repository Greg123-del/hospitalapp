package com.gregory.hospitalapp.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gregory.hospitalapp.dao.interfaces.MedicoDao;
import com.gregory.hospitalapp.model.Medico;


@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoDao medicoDao;
	
	
	@RequestMapping(value="/cadastrarMedico", method = RequestMethod.GET)
	public String save() {
		return "medicos/inserir";
	}
	
	@RequestMapping(value="/cadastrarMedico",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Medico medico) {
		
		try {
			Medico medicoModel = medicoDao.findByUsername(medico.getNum_regi());
			if(medicoModel!=null) {
				return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
			}
					
			medicoModel = medicoDao.save(medico);
			return new ResponseEntity<>(medicoModel, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		

	
	@RequestMapping (value = "/{ID_MEDICO}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long ID_MEDICO) {
		Optional<Medico> findById = medicoDao.findById(ID_MEDICO);
		
		if(findById.isPresent()) {
			medicoDao.delete(findById.get());
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/liberarMedico", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> release(@RequestBody int num_regi) {
		int medicoModel = medicoDao.release(num_regi);
		return new ResponseEntity<>(medicoModel, HttpStatus.OK);
	}
	
	
	@RequestMapping("/listarMedicoAtendimento")
	public List<Medico> listarMedicos2() {
		List<Medico> Medicolist = (List<Medico>) medicoDao.findMedico2();
		return Medicolist;
	}
	
	@RequestMapping("/listarMedico")
	public List<Medico> listarMedicos() {
		List<Medico> Medicolist = (List<Medico>) medicoDao.findMedico();
		return Medicolist;
	}
	

	
}