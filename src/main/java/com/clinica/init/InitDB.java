package com.clinica.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinica.model.entity.Usuario;
import com.clinica.model.repository.AuthorityRepository;
import com.clinica.model.repository.UsuarioRepository;

@Service
public class InitDB implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		Usuario admin = new Usuario();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin"));
		admin.setApellidos("admin");
		admin.setNombres("administrador");
		admin.setCargo("admin");
		admin.setEnable(true);
		
		Usuario enrique = new Usuario();
		enrique.setUsername("eflorez");
		enrique.setPassword(passwordEncoder.encode("Eflorez"));
		enrique.setApellidos("Flores");
		enrique.setNombres("Enrique");
		enrique.setCargo("medico");
		enrique.setEnable(true);
		
		admin.addAuthority("USER");
		admin.addAuthority("ADMIN");
		enrique.addAuthority("DOCTOR");
		enrique.addAuthority("USER");
		
		List<Usuario> usuarios = Arrays.asList(admin,enrique);
		this.usuarioRepository.saveAll(usuarios);
		
		
	}
	

}
