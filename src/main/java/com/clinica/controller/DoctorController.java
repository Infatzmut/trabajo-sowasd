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

import com.clinica.model.entity.Cita;
import com.clinica.model.entity.Doctor;
import com.clinica.model.entity.Especialidad;
import com.clinica.model.entity.Paciente;
import com.clinica.model.entity.TipoAtencion;
import com.clinica.model.repository.DoctorRepository;
import com.clinica.service.CitaService;
import com.clinica.service.DoctorService;
import com.clinica.service.EspecialidadService;
import com.clinica.service.PacienteService;
import com.clinica.service.TipoAtencionService;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private TipoAtencionService tipoAtencionService;
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private PacienteService pacienteService;
	
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
				model.addAttribute("doctor", optional.get());
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
	
	// Try to save a cita from doctor inspect
	@GetMapping("/info/{id}/cita")
	public String añadirCita(@PathVariable("id") int id, Model model) {
		Cita cita = new Cita();
		model.addAttribute("cita",cita);
		try {
			Optional<Doctor> doctor = doctorService.findById(id);
			model.addAttribute("doctor",doctor.get());
			List<TipoAtencion> tiposAtencion = tipoAtencionService.findAll();
			model.addAttribute("tiposAtencion", tiposAtencion);
			List<Paciente> pacientes = pacienteService.findAll();
			model.addAttribute("pacientes", pacientes);
		} catch(Exception e) {System.out.println(e.getMessage());}
		return "medico/cita";
	}
	
	@PostMapping("/save/{id}/cita")
	public String saveCita(@PathVariable("id") int id,@ModelAttribute("cita") Cita cita,
			@ModelAttribute("doctor") Doctor doctor, Model model) {
		try {
			cita.setDoctor(doctor);
			citaService.save(cita);
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "redirect:/doctor/info/"+id;
	}
	// end try
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
