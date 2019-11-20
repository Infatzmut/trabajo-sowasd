package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer>{

}
