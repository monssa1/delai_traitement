package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.TypeDossierRepository;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.TypeDossier;
import com.example.demo.metier.ITypeDossier;

@Controller
public class ParametreServeur {
	@Autowired 
	private TypeDossierRepository typdocr;
	@Autowired
	private ITypeDossier itype;
	
	@RequestMapping(value="/addtype",method = RequestMethod.POST )
	public String Ajouttype(@RequestParam(name="nomtype") String nomtype){
		    TypeDossier typedossier =  new TypeDossier();
		    typedossier.setNomtype(nomtype);
		    if(typedossier.getNomtype()!= ""){
			typdocr.save(typedossier);    
			}      	
		return "redirect:/param";
    }
	
	@GetMapping(value="/supprimertype")
	public String deletetype( Integer id){
        TypeDossier t = typdocr.findByIdDossier(id);
        typdocr.delete(t);

		return "redirect:/param";
    }

	@RequestMapping(value="/modifiertype",method = RequestMethod.GET )
	public String redirectiontype(Model model,@RequestParam(name="id") Integer id){
		TypeDossier typeDossier = typdocr.findByIdDossier(id);

		model.addAttribute("typedossier",typeDossier);
         
		return "modifiertype";
    }
	
	@RequestMapping(value="/addtyped",method = RequestMethod.POST )
	public String AjouttypedModif(@ModelAttribute TypeDossier typeDossier,@RequestParam(name="id") Integer id){
		typeDossier.setId(id);
		 if(typeDossier.getNomtype()!= ""){
	    typdocr.save(typeDossier);
		 }
		return "redirect:/param";
    }
//	@RequestMapping(value="/listetypes")
//	public String Listetypedossier(Model model,@RequestParam(name="page",defaultValue="0")int page,
//			@RequestParam(name="size",defaultValue="7")int size){
//    try {
//    	Page<TypeDossier> pagetypedossier = itype.listetype(page,size);
//		model.addAttribute("listetypes",pagetypedossier);
//		int[] pages = new int[pagetypedossier.getTotalPages()];
//		model.addAttribute("pages",pages);
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//       		
//		return "parametre";
//}
}
