package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tranmission
 *
 */
@Entity
@Table(name="t_transmission")
public class Transmission implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateReception;
	@Temporal(TemporalType.DATE)
	private Date dateTransmission;
	@ManyToOne
	@JoinColumn(name = "EMPLOYE_ID")
	private Employe employe;
	@ManyToOne
	@JoinColumn(name = "DOSSIERCLIENT_ID")
	private DossierClient dossierClient;
	@ManyToOne
	@JoinColumn(name = "CHEF_ID")
	private Chef chef;
	private String status;
	private String observation;
	public Employe getEmploye() {
		return employe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public DossierClient getDossierClient() {
		return dossierClient;
	}
	public void setDossierClient(DossierClient dossierClient) {
		this.dossierClient = dossierClient;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateReception() {
		return dateReception;
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	public Date getDateTransmission() {
		return dateTransmission;
	}
	public void setDateTransmission(Date dateTransmission) {
		this.dateTransmission = dateTransmission;
	}
	public Transmission() {
		super();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Transmission(Long id, Date dateReception, Date dateTransmission, Employe employe,
			DossierClient dossierClient, Chef chef, String status, String observation) {
		super();
		this.id = id;
		this.dateReception = dateReception;
		this.dateTransmission = dateTransmission;
		this.employe = employe;
		this.dossierClient = dossierClient;
		this.chef = chef;
		this.status = status;
		this.observation = observation;
	}
   
}
