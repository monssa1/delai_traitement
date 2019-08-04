package com.example.demo.web;

import java.util.List;

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
import com.example.demo.entities.Bureau;
import com.example.demo.entities.Chef;
import com.example.demo.entities.Employe;
import com.example.demo.metier.IChef;

@Controller
public class ChefServeur {
	@Autowired
	private IChef ichef;
	@Autowired
	private BureauRepository bureauRepository;
	@Autowired
	private ChefRepository chefRepository;
	List<Bureau> l_bureaux;
	
	
	@RequestMapping("/ch")
	public String recette(Model model,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="7")int size){
	
		try {
			l_bureaux = bureauRepository.findAll();
			model.addAttribute("l_bureaux",l_bureaux);
			Page<Chef> pagechef = ichef.listechef(page, size);
			model.addAttribute("listechefs",pagechef);
			int[] pages = new int[pagechef.getTotalPages()];
			model.addAttribute("pages",pages);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return "chef";
	}

	@RequestMapping(value="/addchef",method = RequestMethod.POST )
	public String Ajoutchef(@RequestParam(name="nom") String nom ,@RequestParam(name="prenom") String prenom,
			@RequestParam(name="matricule") String matricule,@RequestParam(name="nomDivision") String nomDivision,
			@RequestParam(name="bureau") Bureau bureau){
		    
		   Chef c = new Chef();
		   c.setBureau(bureau);
		   c.setMatricule(matricule);
		   c.setNom(nom);
		   c.setNomDivision(nomDivision);
		   c.setPrenom(prenom);
			if(c.getNom()!= "" && c.getNomDivision()!= "" && c.getPrenom()!="" && c.getMatricule()!="" && c.getBureau()!= null){
		   chefRepository.save(c);		
			}
		return "redirect:/ch";
    }
	@GetMapping(value="/supprimerchef")
	public String deletechef( Integer id){
		Chef chef= chefRepository.findByIdChef(id);
        chefRepository.delete(chef);
		return "redirect:/ch";
    }
	@RequestMapping(value="/modifierchef",method = RequestMethod.GET )
	public String redirectionchef(Model model,@RequestParam(name="id") Integer id){
		Chef chef = chefRepository.findByIdChef(id);
		l_bureaux = bureauRepository.findAll();
		model.addAttribute("l_bureaux",l_bureaux);

		model.addAttribute("chef",chef);
         
		return "modifierchef";
		}
	@RequestMapping(value="/modifchef",method = RequestMethod.POST )
	public String AjoutChefModif(@ModelAttribute Chef chef,@RequestParam(name="id") Integer id){
		chef.setId(id);
		if(chef.getNom()!= "" && chef.getNomDivision()!= "" && chef.getPrenom()!="" && chef.getMatricule()!="" && chef.getBureau()!= null){
			  	
		chefRepository.save(chef);
		}
		return "redirect:/ch";
    }
}
