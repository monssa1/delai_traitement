package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Bureau;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.TypeDossier;

public interface ITypeDossier {
	public Page<TypeDossier> listetype(int page,int size);
	public Page<Bureau> listebureau(int page,int size);

}
