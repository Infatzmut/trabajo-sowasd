package com.clinica;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clinica.model.entity.Cita;
import com.clinica.model.entity.Clinica;
import com.clinica.model.entity.Doctor;
import com.clinica.model.entity.Paciente;
import com.clinica.model.entity.Proveedor;
import com.clinica.model.repository.CitaRepository;
import com.clinica.model.repository.ClinicaRepository;
import com.clinica.model.repository.DoctorRepository;
import com.clinica.model.repository.EspecialidadRepository;
import com.clinica.model.repository.PacienteRepository;
import com.clinica.model.repository.ProveedorRepository;
import com.clinica.model.entity.Especialidad;

@SpringBootTest
class TrabajoSowasdApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	EspecialidadRepository especialidadRepository;
	
	@Autowired
	CitaRepository citaRepository;
	
	@Autowired
	ClinicaRepository clinicaRepository;
	
	@Autowired
	ProveedorRepository proveedorRepository;
	@Test
	void contextLoads() {
		try {
			// Pacientes
			Paciente juan = new Paciente();
			juan.setNombre("Juan Perez");
			juan.setGenero("Masculino");
			juan.setTelefono(987887443);
			juan.setNacimiento(new Date(1994, 4, 5));
			
			Paciente carlos = new Paciente();
			carlos.setNombre("Carlos Sanchez");
			carlos.setGenero("Masculino");
			carlos.setTelefono(547889665);
			carlos.setNacimiento(new Date(1890, 6, 4));
			
			Paciente pedro = new Paciente();
			pedro.setNombre("Pedro Gutierrez");
			pedro.setGenero("Masculino");
			pedro.setTelefono(987887447);
			pedro.setNacimiento(new Date(1994, 4, 5));
			
			Paciente ximena = new Paciente();
			ximena.setNombre("Ximena Marlith");
			ximena.setGenero("Femenino");
			ximena.setTelefono(897456123);
			ximena.setNacimiento(new Date(1994, 10, 8));
			
			juan = pacienteRepository.save(juan);
			carlos = pacienteRepository.save(carlos);
			pedro = pacienteRepository.save(pedro);
			ximena = pacienteRepository.save(ximena);
			
			// Doctores
			Doctor enrique = new Doctor();
			enrique.setName("Enrique Flores");
			enrique.setDireccion("Av brasil 2230");
			enrique.setGenero("masculino");
			enrique.setTelefono(887744589);
			
			Doctor luis = new Doctor();
			luis.setName("Luis Perez");
			luis.setDireccion("Tomas marsano 1025");
			luis.setGenero("masculino");
			luis.setTelefono(996558221);
			
			Doctor lucia = new Doctor();
			lucia.setName("Lucia De la Cruz");
			lucia.setDireccion("Av jose larco 1010");
			lucia.setGenero("femenino");
			lucia.setTelefono(547896321);
			
			enrique = doctorRepository.save(enrique);
			luis = doctorRepository.save(luis);
			lucia = doctorRepository.save(lucia);
			
			// Especialidad 
			
			Especialidad cirujano = new Especialidad();
			cirujano.setDescripcion("Cirujano");
			Especialidad cardiologo = new Especialidad();
			cardiologo.setDescripcion("Cardiologo");
			Especialidad ginecologo = new Especialidad();
			ginecologo.setDescripcion("Ginecologo");
			
			cirujano = especialidadRepository.save(cirujano);
			cardiologo = especialidadRepository.save(cardiologo);
			ginecologo = especialidadRepository.save(ginecologo);
			
			// Clínica
			
			Clinica clinica1 = new Clinica();
			clinica1.setNombre("Clinica 1");
			clinica1.setDireccion("jr independencia 338");
			clinica1.setTelefono(845789);
			
			clinica1 = clinicaRepository.save(clinica1);
			
			// Cita
			
			Cita cita1 = new Cita();
			cita1.setHora("11 am");
			cita1.setFecha(new Date(2019, 6, 8));
			Cita cita2 = new Cita();
			cita2.setHora("1 pm");
			cita2.setFecha(new Date(2020, 1, 5));
			
			cita1 = citaRepository.save(cita1);
			cita2 = citaRepository.save(cita2);
			
			//Proveedores 
			
			Proveedor prov1 = new Proveedor();
			prov1.setName("Medicinas SAC");
			prov1.setDireccion("Las begonias 2020");
			prov1.setEmail("medicianas@proveedor.com");
			prov1.setTelefono("4444-777");
			
			prov1 = proveedorRepository.save(prov1);
			
			// Grabar
			pacienteRepository.save(juan);
			pacienteRepository.save(carlos);
			pacienteRepository.save(pedro);
			pacienteRepository.save(ximena);
			doctorRepository.save(enrique);
			doctorRepository.save(luis);
			doctorRepository.save(lucia);
			especialidadRepository.save(cirujano);
			especialidadRepository.save(cardiologo);
			especialidadRepository.save(ginecologo);
			clinicaRepository.save(clinica1);
			citaRepository.save(cita1);
			citaRepository.save(cita2);
			proveedorRepository.save(prov1);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
