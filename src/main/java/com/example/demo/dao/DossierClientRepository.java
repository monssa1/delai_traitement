package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.DossierClient;
import com.example.demo.entities.TypeDossier;

public interface DossierClientRepository extends JpaRepository<DossierClient,Integer>{
	@Query("select d from DossierClient d where d.matricule= :x")
	public DossierClient findByMatricule(@Param("x") String mat);
	@Query("select o from DossierClient o ")
	public Page<DossierClient> listdossier(Pageable pageable);
//	@Query("update DossierClient SET nom= :x ,prenom= y , DossierClient.typedossier= :t , datedepot= :d" where matricule= :z)
//	public DossierClient updatedossier(@Param("x") String nom,@Param("y") String prenom,@Param("t") TypeDossier typedossier,@Param("d") String datedepot,@Param("z") String matricule);

}
