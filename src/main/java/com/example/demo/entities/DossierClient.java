package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: DossierClient
 *
 */
@Entity
@Table(name="t_dossierclient")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class DossierClient implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name = "DOSSIERCLIENT_ID") 
	private Long id;
	@Column(unique=true)
	private String matricule;
	@Column(unique=true)
	private String numerodepot;
	private String nom;
	private String prenom;
	@ManyToOne
	private Employe employe ;	
	@Temporal(TemporalType.DATE)
	private Date datedepot;
	@OneToMany(mappedBy = "dossierClient")
	private List<Transmission> transmissions;
	@ManyToOne
	private TypeDossier typedossier ;
	public List<Transmission> getTransmission() {
		return transmissions;
	}

	public void setTransmission(List<Transmission> transmissions) {
		this.transmissions = transmissions;
	}
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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

	public DossierClient() {
		super();
	}

	public DossierClient(Long id, String matricule, String numerodepot, String nom, String prenom, Employe employe,
			Date datedepot,  TypeDossier typedossier) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.numerodepot = numerodepot;
		this.nom = nom;
		this.prenom = prenom;
		this.employe = employe;
		this.datedepot = datedepot;
		this.typedossier = typedossier;
	}

	public String getNumerodepot() {
		return numerodepot;
	}

	public void setNumerodepot(String numerodepot) {
		this.numerodepot = numerodepot;
	}

	public Date getDatedepot() {
		return datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public TypeDossier getTypedossier() {
		return typedossier;
	}

	public void setTypedossier(TypeDossier typedossier) {
		this.typedossier = typedossier;
	}

	public List<Transmission> getTransmissions() {
		return transmissions;
	}

	public void setTransmissions(List<Transmission> transmissions) {
		this.transmissions = transmissions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


   
}
