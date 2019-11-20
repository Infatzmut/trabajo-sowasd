package com.clinica.service;

import java.util.Optional;

import com.clinica.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer>{
		Optional<Usuario> findByUsername(String username) throws Exception;
}
