package com.example.demo.metier;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Bureau;
import com.example.demo.entities.Chef;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Transmission;
import com.example.demo.entities.TypeDossier;

public interface ITraitemantMetier  {
	public void AddDossier(String matricule,String numérodepot, String nom,String prenom,Employe employe,Date datedepot,TypeDossier typedossier);
	public List<DossierClient> list();
	public List<DossierClient> listByDateandStatus();
	public int delete(int id);
	public int update(DossierClient doc);
	public DossierClient GetDossierbyMatricule(String matricule);
	public DossierClient GetDossierByStatus(String status);
	public Page<Transmission> listeTransmissionrecu(int page,int size,Chef chef);
	public Page<Transmission> listeTransmissionfaite(int page,int size,Employe employe);

}
