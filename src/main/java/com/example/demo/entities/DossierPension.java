/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author md
 */
@Entity
public class DossierPension extends DossierClient {
     
	private String id_matriculepension ;
	private String matriculepension ;
	private static final long serialVersionUID = 1L;
	
	public DossierPension(String id_matriculepension,String matriculepension) {
		super();
		this.id_matriculepension = id_matriculepension;
		this.matriculepension = matriculepension;
	}
	public String getId_matriculepension() {
		return id_matriculepension;
	}
	public void setId_matriculepension(String id_matriculepension) {
		this.id_matriculepension = id_matriculepension;
	}
	public String isMatriculepension() {
		return matriculepension;
	}
	public void setMatriculepension(String matriculepension) {
		this.matriculepension = matriculepension;
	}
	public DossierPension() {
		super();
	}



}
