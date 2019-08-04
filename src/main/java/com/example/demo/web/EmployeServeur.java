package com.example.demo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BureauRepository;
import com.example.demo.dao.ChefRepository;
import com.example.demo.dao.EmployeRepository;
import com.example.demo.entities.Chef;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Employe;
import com.example.demo.entities.TypeDossier;
import com.example.demo.metier.IEmploye;

@Controller
public class EmployeServeur {

	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private BureauRepository bureauRepository;
	@Autowired
	private ChefRepository chefRepository;
	@Autowired
	private IEmploye iEmploye;
    List<Chef> l_chefs ,l_chefs2 ;
    
	@RequestMapping("/emp")
	public String recette(Model model,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="7")int size){
	
		try {
			
			Page<Employe> pageempl = iEmploye.listeemp(page, size);
			
			l_chefs = chefRepository.findAll();
			model.addAttribute("l_chefs",l_chefs);
			model.addAttribute("listeemployes",pageempl);
			
//			for (Employe employe : pageempl) {
//				System.out.println(1);
//				System.out.println(employe.getChef());
//			
//			}
//			for (Chef c : l_chefs2) {
//				System.out.println(1);
//				System.out.println(c.getNomDivision());
//			}
//			model.addAttribute("l_chefs2",l_chefs2);
			int[] pages = new int[pageempl.getTotalPages()];
			model.addAttribute("pages",pages);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return "employe";
	}
	@RequestMapping(value="/addemploye",method = RequestMethod.POST )
	public String Ajoutemploye(@RequestParam(name="nom") String nom ,@RequestParam(name="prenom") String prenom,
			@RequestParam(name="matricule") String matricule,@RequestParam(name="chef") Chef chef){
		    
		Employe e = new Employe();
		//System.out.println(matricule+" "+nom+" "+prenom+" "+chef);
		
//			Chef c = chefRepository.findByIdChef(id);
			e.setMatricule(matricule);
			e.setNom(nom);
			e.setPrenom(prenom);
			e.setChef(chef);
			if(e.getMatricule()!= "" && e.getNom()!= "" && e.getPrenom()!= "" && e.getChef()!=null){
			employeRepository.save(e);
			}
		return "redirect:/emp";
    }
	@GetMapping(value="/supprimeremp")
	public String deletetype( Integer id){
		Employe employe = employeRepository.findByIdEmploye(id);
        employeRepository.delete(employe);
		return "redirect:/emp";
    }
	@RequestMapping(value="/modifieremp",method = RequestMethod.GET )
	public String redirectiontype(Model model,@RequestParam(name="id") Integer id){
		Employe employe = employeRepository.findByIdEmploye(id);
		l_chefs = chefRepository.findAll();
		model.addAttribute("l_chefs",l_chefs);

		model.addAttribute("employe",employe);
         
		return "modifieremp";
    }
	@RequestMapping(value="/modifemploye",method = RequestMethod.POST )
	public String AjoutemployeModif(@ModelAttribute Employe employe,@RequestParam(name="id") Integer id){
		employe.setId(id);
		if(employe.getMatricule()!= "" && employe.getNom()!= "" && employe.getPrenom()!= "" && employe.getChef()!=null){
	    employeRepository.save(employe);
	    }
		return "redirect:/emp";
    }

}
