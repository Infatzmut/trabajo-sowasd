package com.clinica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.model.entity.Cita;
import com.clinica.model.entity.Doctor;
import com.clinica.model.entity.Paciente;
import com.clinica.model.entity.TipoAtencion;
import com.clinica.service.CitaService;
import com.clinica.service.DoctorService;
import com.clinica.service.PacienteService;
import com.clinica.service.TipoAtencionService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	PacienteService pacienteService;
	
	@Autowired
	TipoAtencionService tipoAtencionService;
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	CitaService citaService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Paciente> pacientes = pacienteService.findAll();
			model.addAttribute("pacientes",pacientes);
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "paciente/index";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		try {
			Paciente paciente = new Paciente();
			model.addAttribute("paciente",paciente);
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "paciente/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("paciente") Paciente paciente,
			Model model) {
		try {
			pacienteService.save(paciente);
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "redirect:/paciente";
	}
	
	@PostMapping("/save/{id}")
	public String update(@ModelAttribute("paciente") Paciente paciente) {
		try {
			pacienteService.update(paciente);
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "redirect:/paciente";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		try {
			Optional<Paciente> optional = pacienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("paciente", optional.get());
			} else {
				return "redirect:/paciente";
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "paciente/edit";	
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			if(paciente.isPresent()) {
				pacienteService.deleteById(id);
			}
		} catch(Exception e) { 
			model.addAttribute("danger","No tiene permisos para realizar esta accion");
			System.out.println(e.getMessage());}
		return "redirect:/paciente";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			if(paciente.isPresent()) {
				model.addAttribute("paciente",paciente.get());
			}
		} catch(Exception e) {System.out.println(e.getMessage());}
	return "/paciente/info";
	}
	
	// Try to save a cita from paciente inspect
	@GetMapping("/info/{id}/cita")
	public String añadirCita(@PathVariable("id") int id, Model model) {
		Cita cita = new Cita();
		model.addAttribute("cita",cita);
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			model.addAttribute("paciente",paciente.get());
			List<TipoAtencion> tiposAtencion = tipoAtencionService.findAll();
			model.addAttribute("tiposAtencion", tiposAtencion);
			List<Doctor> doctores = doctorService.findAll();
			model.addAttribute("doctores", doctores);
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "paciente/cita";
		}
		
	@PostMapping("/save/{id}/cita")
	public String saveCita(@PathVariable("id") int id,@ModelAttribute("cita") Cita cita,
		@ModelAttribute("paciente") Paciente paciente, Model model) {
		try {
			cita.setPaciente(paciente);
			citaService.save(cita);
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "redirect:/paciente/info/"+id+"/citas";
		}
	
	@GetMapping("/info/{id}/citas")
	public String verCitas(@PathVariable("id") int id,Model model) {
		try {
			Optional<Paciente> paciente = pacienteService.findById(id);
			if(paciente.isPresent()) {
				model.addAttribute("paciente",paciente.get());
				List<Cita> citas = citaService.findByPacienteCitas(id);
				model.addAttribute("citas",citas);
			}
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "paciente/citas";
	}
}
