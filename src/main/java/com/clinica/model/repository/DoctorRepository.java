package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
