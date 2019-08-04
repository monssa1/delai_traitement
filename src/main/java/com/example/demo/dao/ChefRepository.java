package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Chef;

public interface ChefRepository extends JpaRepository<Chef,Integer> {
	@Query("select td from Chef td where td.id= :x")
	public Chef findByIdChef(@Param("x") Integer id);
	@Query("select o from Chef o ")
	public Page<Chef> listechef(Pageable pageable);

}
