package com.gregory.hospitalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gregory.hospitalapp.dao.interfaces.*;
import com.gregory.hospitalapp.model.*;

@Controller
public class PacienteController {
	@Autowired
	private PacientesDao pacienteDao;
	
	@RequestMapping(value="/cadastrarPaciente", method = RequestMethod.GET)
	public String save() {
		return "pacientes/inserir";
	}
	
	@RequestMapping(value="/cadastrarPaciente", method = RequestMethod.POST)
	public String save(Paciente paciente) {
		
		pacienteDao.save(paciente);
		
		return "redirect:/cadastrarPaciente";
	}
	
	
	@RequestMapping(value="/atenderPaciente", method = RequestMethod.GET)
	public String updateAtender() {
		return "pacientes/atenderPaciente";
	}
	
	@RequestMapping(value="/atenderPaciente", method = RequestMethod.PUT)
	public String updateAtender(Integer num_regi) {
		
		pacienteDao.updateAtender(num_regi);
		return "redirect:/atenderPaciente";
	}
	
	
	
	@RequestMapping("/listarPaciente")
	public ModelAndView listarPacientes() {
		ModelAndView mv = new ModelAndView("/index");
		Iterable<Paciente> pacientes = pacienteDao.findAllPaciente();
		
		mv.addObject("pacientes", pacientes);
		return mv;
		
	}
}
