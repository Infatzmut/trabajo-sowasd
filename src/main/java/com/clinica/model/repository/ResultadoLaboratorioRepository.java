package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.ResultadoLaboratorio;

@Repository
public interface ResultadoLaboratorioRepository extends JpaRepository<ResultadoLaboratorio, Integer>{

}
