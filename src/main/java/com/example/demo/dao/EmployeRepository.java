package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{
	@Query("select o from Employe o ")
	public Page<Employe> listeemp(Pageable pageable);
	@Query("select td from Employe td where td.id= :x")
	public Employe findByIdEmploye(@Param("x") Integer id);

}
