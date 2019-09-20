package com.gregory.hospitalapp.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gregory.hospitalapp.model.Medico;
import com.gregory.hospitalapp.model.Paciente;
import com.gregory.hospitalapp.dao.interfaces.*;



@Controller
public class MedicoController {
	
	@Autowired
	private MedicoDao medicoDao;
	
	@RequestMapping(value="/cadastrarMedico", method = RequestMethod.GET)
	public String save() {
		return "medicos/inserir";
	}
	
	@RequestMapping(value="/cadastrarMedico", method = RequestMethod.POST)
	public String save(Medico medico) {
		
		medicoDao.save(medico);
		
		return "redirect:/cadastrarMedico";
	}
	
	@RequestMapping(value="/deletarMedico", method = RequestMethod.DELETE)
	public String deletarMedico(@PathVariable("ID_MEDICO")Medico id) {
		medicoDao.delete(id);
		return "redirect:/";
		
	}
	
	@RequestMapping("/listarMedico")
	public ModelAndView listarMedicos() {
		ModelAndView mv = new ModelAndView("pacientes/atenderPaciente");
		Iterable<Medico> medicos = medicoDao.findMedico();
		
		mv.addObject("medicos", medicos);
		return mv;
		
	}
}