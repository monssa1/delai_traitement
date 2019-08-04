package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ChefRepository;
import com.example.demo.dao.TypeDossierRepository;
import com.example.demo.entities.Bureau;
import com.example.demo.entities.Chef;
import com.example.demo.entities.Employe;
import com.example.demo.entities.TypeDossier;
import com.example.demo.metier.IChef;
import com.example.demo.metier.IEmploye;
import com.example.demo.metier.ITypeDossier;


@Controller
public class MenuServlet {
	@Autowired
	private TypeDossierRepository dossierRepository;
	@Autowired
	private ITypeDossier itype;
	@Autowired
	private ChefRepository chefRepository;
	@Autowired
	private IChef ichef;
	@Autowired
	private IEmploye iEmploye;
    List<TypeDossier> typesdossiers;
    List<Chef> l_chefs ;
    List<Employe> employes;
	
	
	@RequestMapping("/lic")
	public String index(Model model ){
		
		return "liquidation";
	}
//	@RequestMapping("/cou")
//	public String courrier(Model model ){
//		
//		return "courrier";
//	}
	@RequestMapping("/bur")
	public String bureau(Model model,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="7")int size ){
		
		try {
	    	Page<Bureau> pagebureaux = itype.listebureau(page, size);
			model.addAttribute("listebureaux",pagebureaux);
			int[] pages = new int[pagebureaux.getTotalPages()];
			model.addAttribute("pages",pages);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				return "bureau";
	}
		
	@RequestMapping("/con")
	public String controle(Model model ){
		typesdossiers = dossierRepository.findAll();
   		model.addAttribute("l_typedocs",typesdossiers);
		return "controle";
	}
	@RequestMapping("/param")
	public String parametre(Model model,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="7")int size ){
		try {
	    	Page<TypeDossier> pagetypedossier = itype.listetype(page,size);
			model.addAttribute("listetypes",pagetypedossier);
			int[] pages = new int[pagetypedossier.getTotalPages()];
			model.addAttribute("pages",pages);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return "parametre";
	}

}
