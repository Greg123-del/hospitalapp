package com.gregory.hospitalapp.dao.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gregory.hospitalapp.model.*;


public interface MedicoDao extends CrudRepository<Medico, Long> {
	@Query(value = "SELECT * FROM medico m left join paciente p on m.id_medico = p.ID_MEDICO_FK where ID_MEDICO_FK is null", nativeQuery = true)
	Iterable<Medico> findMedico();
	
}