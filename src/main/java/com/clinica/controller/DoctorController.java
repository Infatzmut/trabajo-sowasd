package com.clinica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.clinica.model.entity.Doctor;
import com.clinica.model.entity.Especialidad;
import com.clinica.model.repository.DoctorRepository;
import com.clinica.service.DoctorService;
import com.clinica.service.EspecialidadService;


@Controller
@RequestMapping("/doctor")
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
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Doctor> optional = doctorService.findById(id);	
			if(optional.isPresent()) {
				model.addAttribute("doct", optional.get());
				List <Especialidad> especialidades = especialidadService.findAll();
				model.addAttribute("especiales", especialidades);	
			} else {
				return "redirect:/doctor";
			}
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "medico/edit";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		try {
			List<Especialidad> especialidades = especialidadService.findAll();
			model.addAttribute("especialidades", especialidades);
		} catch(Exception e) {}
		return "medico/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("doctor") Doctor doctor,
			Model model, SessionStatus status) {
		try {
			doctorService.save(doctor);
			status.setComplete();
		}catch(Exception e) {System.out.println(e.getMessage());}
		
		return "redirect:/doctor";
	}
	
	@PostMapping("/save/{id}")
	public String update(@ModelAttribute("doctor") Doctor doctor,
			Model model, SessionStatus status) {
		try {
			doctorService.update(doctor);
			status.setComplete();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/doctor";
	}
	
	@GetMapping("/info/{id}")
	public String inspeccionarDoctor(@PathVariable("id") int id, Model model) {
		try {
			Optional<Doctor> optional = doctorService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("doctor",optional.get());	
			} else {
				model.addAttribute("error","doctor no encontrado");
				return "redirect:/doctor";
			}
		} catch(Exception e) {System.out.println(e.getMessage());		
		}
		return "medico/info";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Doctor> doctor = doctorService.findById(id);
			if(doctor.isPresent()) {
				doctorService.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("dangerDel", "Error - Violacion contra el principio de integridad");
			try {
				List<Doctor> doctores = doctorService.findAll();
				model.addAttribute("doctores", doctores);
			} catch(Exception e2) {}
			return "medico/inicio";
		}
		return "redirect:/doctor";
	}
	
}
