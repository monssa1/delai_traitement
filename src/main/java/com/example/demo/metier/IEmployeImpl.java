package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeRepository;
import com.example.demo.entities.Employe;
@Service
public class IEmployeImpl implements IEmploye{
    @Autowired
    private EmployeRepository employerepository;
	@Override
	public Page<Employe> listeemp(int page, int size) {
		
		return employerepository.listeemp(new PageRequest(page, size));
	}

}
