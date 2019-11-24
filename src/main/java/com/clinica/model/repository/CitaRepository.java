package com.clinica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{
	@Query(value= "SELECT * FROM cita where paciente_id=?1", nativeQuery=true)
	List<Cita> findByPacienteCitas(Integer id);
	
	@Query(value= "SELECT * FROM cita where doctor_id=?1", nativeQuery=true)
	List<Cita> findByDoctorCitas(Integer id);
}
