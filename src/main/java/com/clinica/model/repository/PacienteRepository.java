package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
