package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.DossierClient;

public interface IDossierClient {
	public Page<DossierClient> listdossier(int page,int size);

}
