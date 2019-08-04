package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="typedossier")

public class TypeDossier implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer id;
	private String nomtype;
	@OneToMany(mappedBy = "typedossier")
	private List<DossierClient> dossierclient;
	public TypeDossier(Integer id, String nomtype, List<DossierClient> dossierclient) {
		super();
		this.id = id;
		this.nomtype = nomtype;
		this.dossierclient = dossierclient;
	}
	public TypeDossier() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomtype() {
		return nomtype;
	}
	public void setNomtype(String nomtype) {
		this.nomtype = nomtype;
	}
	public List<DossierClient> getDossierclient() {
		return dossierclient;
	}
	public void setDossierclient(List<DossierClient> dossierclient) {
		this.dossierclient = dossierclient;
	}
	public TypeDossier(Integer id, String nomtype) {
		super();
		this.id = id;
		this.nomtype = nomtype;
	}
	
}
