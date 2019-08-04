package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Employe;

public interface IEmploye {
	public Page<Employe> listeemp(int page,int size);
}
