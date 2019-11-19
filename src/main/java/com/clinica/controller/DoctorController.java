package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.clinica.model.entity.Doctor;
import com.clinica.service.DoctorService;
import com.clinica.service.EspecialidadService;

@Controller
@RequestMapping("/doctor")
@SessionAttributes({"medico","cita"})
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Doctor> doctores = doctorService.findAll();
			model.addAttribute("doctores",doctores);
		}catch(Exception e) {}
		return "medico/inicio";
	}

}
