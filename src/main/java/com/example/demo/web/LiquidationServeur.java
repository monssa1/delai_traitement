package com.example.demo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BureauRepository;
import com.example.demo.dao.ChefRepository;
import com.example.demo.dao.DossierClientRepository;
import com.example.demo.dao.TransmissionRepository;
import com.example.demo.entities.Bureau;
import com.example.demo.entities.Chef;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Transmission;

@Controller
public class LiquidationServeur {
	@Autowired
	private TransmissionRepository transmissionr;
	@Autowired
	private DossierClientRepository dossierc;
	@Autowired
	private ChefRepository chefrepository;
	List<Chef> chefs;
	
	@RequestMapping(value="/licadd",method = RequestMethod.POST )
	public String Addtransmission(@RequestParam("chef") Chef chef,@RequestParam("status")String status,@RequestParam("observation")String observation,@RequestParam("dateReception")String dateReception,@RequestParam("dateTransmission")String dateTransmission,@RequestParam("matricule") String matricule){
        System.out.println(matricule);
		DossierClient d = dossierc.findByMatricule(matricule);
        System.out.println(d.getNom());
	        Transmission t = new Transmission();
	        t.setStatus(status);
	        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	        Date dr= null;
	        Date dt=null;
			try {
				dt = formater.parse(dateTransmission);
				dr = formater.parse(dateReception);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        t.setChef(chef);
	        t.setObservation(observation);
	        t.setDateReception(dr);
	        t.setDateTransmission(dt);
	        t.setDossierClient(d);
		try {
			if(t.getChef()!= null && t.getObservation()!= "" && t.getStatus()!="" && t.getDateReception()!= null && t.getDateTransmission()!= null)
			
				{
				transmissionr.save(t);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
          
		
		return "liquidation";
    }
	@RequestMapping(value="/licrecherche1")
	public String rechercherdossier(Model model,String matricule)
	{
		model.addAttribute("matricule",matricule);
		try {
			chefs = chefrepository.findAll();
			model.addAttribute("chefs",chefs);
			if(matricule!=""){
				DossierClient d = dossierc.findByMatricule(matricule);
				model.addAttribute("dossierclient",d);
			}	
			
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
		
		return "transfertdoc";
		}
	@PostMapping("/save")
	public String save(DossierClient d){
		dossierc.save(d);
		return "redirect:/listedossier";
	}
	
}
