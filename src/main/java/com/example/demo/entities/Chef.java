package com.example.demo.entities;

import com.example.demo.entities.Employe;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chef
 *
 */
@Entity
@Table(name="t_chef")
public class Chef implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CHEF_ID") 
	private Integer id;
	@Column (unique= true)
	private String matricule;
	private String nom;
	private String prenom;
	private String nomDivision;
	@OneToOne(fetch=FetchType.LAZY)
	private Bureau bureau;
	@OneToMany(mappedBy = "chefE")
	private List<Employe> employes;

	public Integer getId() {
		return id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomDivision() {
		return nomDivision;
	}

	public void setNomDivision(String nomDivision) {
		this.nomDivision = nomDivision;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Chef(String nomDivision, Bureau bureau) {
		super();
		this.nomDivision = nomDivision;
		this.bureau = bureau;
		
	}

	public Chef() {
		super();
	}



}
