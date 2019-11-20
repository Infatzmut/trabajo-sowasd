package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{

}
