package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.TipoAtencion;

@Repository
public interface TipoAtencionRepository extends JpaRepository<TipoAtencion, Integer>{

}
