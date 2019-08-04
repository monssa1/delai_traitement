package com.example.demo.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DossierClientRepository;
import com.example.demo.dao.TransmissionRepository;
import com.example.demo.entities.Chef;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Transmission;
import com.example.demo.entities.TypeDossier;

@Controller
@Transactional
public class TraitementMetierImpl implements ITraitemantMetier{
      @Autowired
      private DossierClientRepository dossierclientrepository;
      @Autowired
      private TransmissionRepository transmissionRepository;
  	@Override
  	public void AddDossier(String matricule,String numérodepot, String nom, String prenom,Employe employe,Date datedepot,TypeDossier typedossier) {
  		DossierClient d = new DossierClient(null, matricule, numérodepot, nom, prenom, employe, datedepot, typedossier); 
  				//DossierClient(null, matricule, nom, prenom,employe);
  		dossierclientrepository.save(d);
  	}

	@Override
	public List<DossierClient> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DossierClient> listByDateandStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DossierClient doc) {
		// TODO Auto-generated method stub
		return 0;
	}


	@RequestMapping(value="/recherchedossier",method=RequestMethod.POST)
	public String GetDossierbyMatricule(@RequestParam("id") String matricule,Model model) {
		
		  
		DossierClient dc= dossierclientrepository.findByMatricule(matricule);
		
		if(dc!=null)
			System.out.println(dc.getNom());
		model.addAttribute("dossierclient",dc);
		return "liquidation";
	}

	@Override
	public DossierClient GetDossierByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DossierClient GetDossierbyMatricule(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Transmission> listeTransmissionrecu(int page, int size,Chef chef) {
		
		return transmissionRepository.findTransmissionrecu(new PageRequest(page,size), chef);
	}

	@Override
	public Page<Transmission> listeTransmissionfaite(int page, int size,Employe employe) {

		return transmissionRepository.findTransmissionfaite(new PageRequest(page,size),employe);
	}



}
