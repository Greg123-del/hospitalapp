package com.gregory.hospitalapp.dao.interfaces;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gregory.hospitalapp.model.Medico;


public interface MedicoDao extends CrudRepository<Medico, Long> {
	@Query(value = "SELECT * FROM medico m left join paciente p on m.id_medico = p.ID_MEDICO_FK where ID_MEDICO_FK is null", nativeQuery = true)
	Iterable<Medico> findMedico();
	
	@Query(value = "SELECT * FROM medico m left join paciente p on m.id_medico = p.ID_MEDICO_FK where ID_MEDICO_FK is not null", nativeQuery = true)
	Iterable<Medico> findMedico2();
	
	@Query(value = "select * from hospital2.medico m where m.num_regi = ?", nativeQuery = true)
	Medico findByUsername(int num_regi);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM paciente where ID_MEDICO_FK = (SELECT ID_MEDICO FROM medico WHERE num_regi = ?)", nativeQuery = true)
	int release(int num_regi);

	
	
}
