package com.example.demo.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bureau
 *
 */
@Entity
@Table(name="bureau")
public class Bureau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer id;
	private String nomBureau;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNomBureau() {
		return nomBureau;
	}
	public void setNomBureau(String nomBureau) {
		this.nomBureau = nomBureau;
	}
	
	public Bureau() {
		super();
	}
	public Bureau(Integer id, String nomBureau) {
		super();
		this.id = id;
		this.nomBureau = nomBureau;
	}
	  
}
