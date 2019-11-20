package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
