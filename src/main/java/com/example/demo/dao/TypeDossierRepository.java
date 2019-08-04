package com.example.demo.dao;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Bureau;
import com.example.demo.entities.TypeDossier;

public interface TypeDossierRepository extends JpaRepository<TypeDossier,Integer>{
	@Query("select td from TypeDossier td where td.id= :x")
	public TypeDossier findByIdDossier(@Param("x") Integer id);
	@Query("select o from TypeDossier o ")
	public Page<TypeDossier> listetype(Pageable pageable);
	@Query("select o from Bureau o ")
	public Page<Bureau> listebureau(Pageable pageable);

}
