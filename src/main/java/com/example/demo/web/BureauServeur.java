package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BureauRepository;
import com.example.demo.entities.Bureau;
import com.example.demo.entities.Employe;
import com.example.demo.entities.TypeDossier;

@Controller
public class BureauServeur {

	@Autowired
	private BureauRepository bureaurepository;
	
	@RequestMapping(value="/addbureau",method = RequestMethod.POST )
	public String Ajoutbureau(Model model,@RequestParam(name="nomBureau") String nomBureau){
		Bureau bureau = new Bureau();  
		bureau.setNomBureau(nomBureau);
		if (bureau.getNomBureau() != ""){	
		bureaurepository.save(bureau);
		}else {
			String message = "Login failed. Try again.";
			model.addAttribute("message",message);
			
		}
		        	
		return "redirect:/bur";
    }
	@GetMapping(value="/supprimerbureau")
	public String deletebureau( Integer id){
		Bureau b = bureaurepository.findByIdureau(id);
	bureaurepository.delete(b);
		return "redirect:/bur";
    }
	@RequestMapping(value="/modifierbureau",method = RequestMethod.GET )
	public String redirectionbureau(Model model,@RequestParam(name="id") Integer id){
		Bureau bureau = bureaurepository.findByIdureau(id);
		
		model.addAttribute("bureau",bureau);
         
		return "modifierbureau";
}
	@RequestMapping(value="/modbureau",method = RequestMethod.POST )
	public String AjoutBureauModif(@ModelAttribute Bureau bureau,@RequestParam(name="id") Integer id){
		bureau.setId(id);
		bureaurepository.save(bureau);
		return "redirect:/bur";
    }
}
