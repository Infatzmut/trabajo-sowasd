package com.clinica.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.model.entity.Usuario;
import com.clinica.service.UsuarioService;

@Controller
@RequestMapping("/")
public class IndexController implements ErrorController{

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("login") 
	public String login() {
		return "login";
	}
	
	@GetMapping("verid")
	public String verId(Model model) throws Exception {
		// Obtener el username
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
			Optional<Usuario> optional 
				= usuarioService.findByUsername(username);
			if(optional.isPresent()) {
				model.addAttribute("usuario", optional.get());
			}
			
		return "verid";
	}
	
	@GetMapping("error")
	public String onError() {
		return "error";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
}
