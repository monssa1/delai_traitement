package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Bureau;
import com.example.demo.entities.TypeDossier;

public interface BureauRepository extends JpaRepository<Bureau, Integer>{
	
	@Query("select td from Bureau td where td.id= :x")
	public Bureau findByIdureau(@Param("x") Integer id);

}
