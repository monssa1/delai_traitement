package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity
@Table(name="t_employe")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYE_ID") 
	private Integer id;
	@Column (unique= true)
	private String matricule;
	private String nom;
	private String prenom;
	@ManyToOne
	@JoinColumn(name = "CHEF_ID")
	private Chef chefE;
	@OneToMany(mappedBy = "employe")
	private List<Transmission> transmissions;
	@OneToMany(mappedBy = "employe")
	private List<DossierClient> dossierclient;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public Chef getChefE() {
		return chefE;
	}

	public void setChefE(Chef chefE) {
		this.chefE = chefE;
	}

	public List<DossierClient> getDossierclient() {
		return dossierclient;
	}

	public void setDossierclient(List<DossierClient> dossierclient) {
		this.dossierclient = dossierclient;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Chef getChef() {
		return chefE;
	}

	public void setChef(Chef chef) {
		this.chefE = chef;
	}

	public List<Transmission> getTransmissions() {
		return transmissions;
	}

	public void setTransmissions(List<Transmission> transmissions) {
		this.transmissions = transmissions;
	}

	public Employe() {
		super();
	}

	public Employe(Integer id, String matricule, String nom, String prenom, Chef chef
			) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.chefE = chef;
	}	

}
