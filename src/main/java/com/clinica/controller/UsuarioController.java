package com.clinica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
				usuario.setCargo(usuario.getCargo());
				usuario.addAuthority("USER");
				usuario.setEnable(true);
				usuarioService.save(usuario);
			}
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "login";
	}
	
	@GetMapping("lista")
	public String ListarUsuarios(Model model) {
		try {
			List<Usuario> usuarios = usuarioService.findAll();
			model.addAttribute("usuarios",usuarios);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "usuario/listaUsuarios";
	}
	
	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		try {
			Optional<Usuario> usuario = usuarioService.findById(id);
			if(usuario.isPresent()) {
				usuarioService.deleteById(id);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
		return "redirect:/usuario/lista";
	}
}
