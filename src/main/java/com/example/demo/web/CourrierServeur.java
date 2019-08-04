package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ChefRepository;
import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.TransmissionRepository;
import com.example.demo.entities.Chef;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Transmission;
import com.example.demo.metier.ITraitemantMetier;

@Controller
public class CourrierServeur {
	@Autowired
    private TransmissionRepository transmissionRepository;
	@Autowired 
	private ChefRepository chefr;
	@Autowired
	private ITraitemantMetier ita;
	@Autowired
	private EmployeRepository employerepository;
	
	@RequestMapping(value="/cou")
	public String Listedossier(Model model,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size){
    try {
    	Chef chef= chefr.findByIdChef(2);
    	//session a mettre ici
    	System.out.println(chef.getPrenom()+chef.getNom());
		Page<Transmission> pageTransmission = ita.listeTransmissionrecu(page, size,chef);
		model.addAttribute("l_statistiques",pageTransmission);
	    Employe employe = employerepository.findByIdEmploye(1);
	    Page<Transmission> paget = ita.listeTransmissionfaite(page, size, employe);
		model.addAttribute("l_t",paget);
		int[] pages = new int[pageTransmission.getTotalPages()];
		int[] pagest = new int[paget.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("pagest",pagest);
	} catch (Exception e) {
		// TODO: handle exception
	}
       		
		return "courrier";
    }
}
