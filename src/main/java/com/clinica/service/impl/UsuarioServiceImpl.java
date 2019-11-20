package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clinica.model.entity.Usuario;
import com.clinica.model.repository.UsuarioRepository;
import com.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	public Usuario update(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteAll();
	}

	@Override
	public Optional<Usuario> findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsername(username);
	}

}
