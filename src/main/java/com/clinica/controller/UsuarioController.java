package com.clinica.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.model.entity.Usuario;
import com.clinica.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("register")
	public String register(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "register";
	}
	
	@PostMapping("/save")
	public String guardarRegistro(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		try {
			Optional<Usuario> optional = usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("error","El username"+ usuario.getUsername()+" ya se encuentra en uso");
				return "register";
			} else {
				usuario.setUsername(usuario.getUsername());
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				usuario.setCargo("paciente");
				usuario.addAuthority("USER");
				usuario.setEnable(true);
				usuarioService.save(usuario);
			}
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "login";
	}
}
