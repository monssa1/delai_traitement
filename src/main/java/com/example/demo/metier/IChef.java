package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Chef;


public interface IChef {
	public Page<Chef> listechef(int page,int size);
}
