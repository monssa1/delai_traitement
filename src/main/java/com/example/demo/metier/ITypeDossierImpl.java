package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BureauRepository;
import com.example.demo.dao.TypeDossierRepository;
import com.example.demo.entities.Bureau;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.TypeDossier;
@Service
public class ITypeDossierImpl implements ITypeDossier{
	@Autowired
	private TypeDossierRepository ITypeDossierImpl;
	@Autowired
	private TypeDossierRepository bureaurepository;

	@Override
	public Page<TypeDossier> listetype(int page, int size) {
		
		return ITypeDossierImpl.listetype(new PageRequest(page, size));
	
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<Bureau> listebureau(int page, int size) {
		// TODO Auto-generated method stub
		return bureaurepository.listebureau(new PageRequest(page,size));
	}

}
