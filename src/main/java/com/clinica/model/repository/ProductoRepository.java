package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
