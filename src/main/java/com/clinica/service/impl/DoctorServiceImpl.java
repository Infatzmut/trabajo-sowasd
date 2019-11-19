package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.entity.Doctor;
import com.clinica.model.repository.DoctorRepository;
import com.clinica.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public List<Doctor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Optional<Doctor> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id);
	}

	@Override
	public Doctor save(Doctor entity) throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.save(entity);
	}

	@Override
	public Doctor update(Doctor entity) throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		doctorRepository.deleteAll();
	}

}
