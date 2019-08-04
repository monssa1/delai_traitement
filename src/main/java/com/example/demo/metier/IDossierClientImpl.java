package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DossierClientRepository;
import com.example.demo.entities.DossierClient;
@Service
//@Transactional
public class IDossierClientImpl implements IDossierClient{
	@Autowired
    private DossierClientRepository dossierclient ;

	@Override
	public Page<DossierClient> listdossier(int page, int size) {
		
		return dossierclient.listdossier(new PageRequest(page, size));
	}

}
