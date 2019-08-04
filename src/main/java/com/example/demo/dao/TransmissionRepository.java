package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Chef;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Transmission;
import com.example.demo.entities.TypeDossier;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer>{

	@Query("SELECT t from Transmission t where t.status=:x and t.dossierClient.typedossier.nomtype LIKE :typed AND (t.dossierClient.datedepot between :d AND :f)")
	public List<Transmission> findStatistique(@Param("x") String status,@Param("typed") String typedossier,@Param("d") Date d,@Param("f") Date f);
	@Query("SELECT t from Transmission t where t.chef=:sessionemploye order by t.dateTransmission")
	public Page<Transmission> findTransmissionrecu(Pageable pageable,@Param("sessionemploye") Chef chef);
	@Query("SELECT t from Transmission t where t.employe=:sessionemploye order by t.dateTransmission")
	public Page<Transmission> findTransmissionfaite(Pageable pageable,@Param("sessionemploye") Employe employe);

}
