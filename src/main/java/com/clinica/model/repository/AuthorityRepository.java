package com.clinica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
