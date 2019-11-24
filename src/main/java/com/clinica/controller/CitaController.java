package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.model.entity.Cita;
import com.clinica.model.entity.Doctor;
import com.clinica.model.entity.Paciente;
import com.clinica.service.CitaService;
import com.clinica.service.DoctorService;
import com.clinica.service.PacienteService;

@Controller
@RequestMapping("/cita")
public class CitaController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired CitaService citaService;
	
	@GetMapping("/")
	public String index(Model model) {
		try {
			List<Cita> citas = citaService.findAll();
			model.addAttribute("citas", citas);
		} catch (Exception e) {System.out.println(e.getMessage());}
		return "cita/listcitas";
	}
	@GetMapping("nuevo")
	public String nuevaCita(Model model) {
		Cita cita = new Cita();
		model.addAttribute("cita", cita);	
		try {
		List<Doctor> doctores = doctorService.findAll();
		model.addAttribute("doctores", doctores);
		List<Paciente> pacientes = pacienteService.findAll();
		model.addAttribute("pacientes", pacientes);
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "cita/nueva";
	}
	
	@PostMapping("save")
	public String guardarCita(@ModelAttribute("cita") Cita cita, Model model) {
		try {
			citaService.save(cita);
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "redirect:/cita";
	}
	
	
}
