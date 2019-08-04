package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChefRepository;
import com.example.demo.entities.Chef;

@Service
public class IChefImpl implements IChef{
	@Autowired
	private ChefRepository chefrepository; 

	@Override
	public Page<Chef> listechef(int page, int size) {
		
		return chefrepository.listechef(new PageRequest(page, size));
	}

}
