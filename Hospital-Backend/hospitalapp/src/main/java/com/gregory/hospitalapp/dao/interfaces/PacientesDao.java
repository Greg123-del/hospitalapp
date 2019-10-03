package com.gregory.hospitalapp.dao.interfaces;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gregory.hospitalapp.model.Medico;
import com.gregory.hospitalapp.model.Paciente;

public interface PacientesDao  extends CrudRepository<Paciente, Long> {

	@Query(value = "SELECT * FROM hospital2.paciente WHERE ID_MEDICO_FK is null", nativeQuery = true)
	Collection<Paciente> findAllPaciente();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE paciente SET ID_MEDICO_FK = (SELECT id_medico FROM medico WHERE num_regi = ?) WHERE ID_MEDICO_FK IS NULL ORDER BY ID_PACIENTE LIMIT 1", nativeQuery = true)
	int updateAtender(int num_regi);
}
