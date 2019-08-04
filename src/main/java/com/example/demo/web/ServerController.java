package com.example.demo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.DossierClientRepository;
import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.TypeDossierRepository;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Employe;
import com.example.demo.entities.TypeDossier;
import com.example.demo.metier.IDossierClient;
import com.example.demo.metier.ITraitemantMetier;


@Controller
public class ServerController {
	@Autowired
    private DossierClientRepository dossierclient ;
	
	@Autowired
	private EmployeRepository emp;
	@Autowired
	private ITraitemantMetier itrait;
	@Autowired 
	private TypeDossierRepository typdocr;
	@Autowired
	private IDossierClient idoc;
	List<TypeDossier> typesdossiers ;
	
	@RequestMapping("/front")
	public String index(Model model ){
		typesdossiers = typdocr.findAll();
		model.addAttribute("l_typedocs",typesdossiers);
		return "frontoffice";
	}
	
//	@RequestMapping(value="/adddoc",method = RequestMethod.POST)
//	public String submit(@ModelAttribute Employe employe){
//          emp.save(employe);	
//		
//		return "frontoffice";
//    }
	
	@RequestMapping(value="/modifierdossier",method = RequestMethod.GET )
	public String redirection(Model model,@RequestParam(name="matricule") String matricule){
		typesdossiers = typdocr.findAll();
		model.addAttribute("l_typedocs",typesdossiers);
		DossierClient dc=dossierclient.findByMatricule(matricule);
		model.addAttribute("dossierclient",dc);
		
		//dossierclient.save(dc);
         
		return "modifierdossier";
    }
	@RequestMapping(value="/adddossier",method = RequestMethod.POST )
	public String Ajoutdossier(@RequestParam(name="datedepot") String datedepot,@RequestParam(name="nom") String nom ,
	@RequestParam(name="prenom") String prenom,@RequestParam(name="matricule") String matricule,@RequestParam(name="typedossier") String typedossier
	,@RequestParam(name="numerodepot") String numerodepot){
		System.out.println(datedepot);
		DossierClient dossierc = new DossierClient();
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	        Date dated =null;
			try {
				dated = formater.parse(datedepot);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	//	System.out.println(dossierc.getMatricule());
			int id;
			id = Integer.parseInt(typedossier);
			TypeDossier typed = typdocr.findByIdDossier(id);
			dossierc.setMatricule(matricule);
			dossierc.setPrenom(prenom);
			dossierc.setNom(nom);
		//	dossierc.setEmploye(employe);
		    dossierc.setNumerodepot(numerodepot);
			dossierc.setTypedossier(typed);
            dossierc.setDatedepot(dated);
            if (dossierc.getNom()!= "" && dossierc.getMatricule()!="" && dossierc.getPrenom()!= "" && dossierc.getNumerodepot()!= ""
            		&& dossierc.getDatedepot()!= null && dossierc.getTypedossier()!= null){	
		dossierclient.save(dossierc);
          
            }
		return "redirect:/front";
    }
	@RequestMapping(value="/adddossier2",method = RequestMethod.POST )
	public String AjoutdossierModif(@ModelAttribute DossierClient dossierc,@RequestParam(name="matricule") String matricule){

        dossierc.setMatricule(matricule);
        if (dossierc.getNom()!= "" && dossierc.getMatricule()!="" && dossierc.getPrenom()!= "" && dossierc.getNumerodepot()!= ""
        		&& dossierc.getDatedepot()!= null && dossierc.getTypedossier()!= null){	
		dossierclient.save(dossierc);
          
        }
		return "redirect:/listedossier";
    }
	
	@RequestMapping(value="/listedossier")
	public String Listedossier(Model model,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size){
    try {
		Page<DossierClient> pageDossierClient = idoc.listdossier(page, size);
		model.addAttribute("listedossiers",pageDossierClient);
		int[] pages = new int[pageDossierClient.getTotalPages()];
		model.addAttribute("pages",pages);
	} catch (Exception e) {
		// TODO: handle exception
	}
       		
		return "listedossier";
    }
}