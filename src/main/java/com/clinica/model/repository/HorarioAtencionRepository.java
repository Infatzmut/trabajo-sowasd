package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.HorarioAtencion;

@Repository
public interface HorarioAtencionRepository extends JpaRepository<HorarioAtencion, Integer>{

}
