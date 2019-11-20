package com.clinica.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.model.entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByUsername(String username);
}
