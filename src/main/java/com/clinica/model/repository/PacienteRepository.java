package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
