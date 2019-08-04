package com.example.demo.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BureauRepository;
import com.example.demo.dao.DossierClientRepository;
import com.example.demo.dao.TransmissionRepository;
import com.example.demo.dao.TypeDossierRepository;
import com.example.demo.entities.DossierClient;
import com.example.demo.entities.Transmission;
import com.example.demo.entities.TypeDossier;
import com.mysql.jdbc.Buffer;

       @Controller
       public class StatistiqueServer {
       @Autowired
       private DossierClientRepository clientRepository;
       @Autowired
       private TypeDossierRepository dossierRepository;
       List<TypeDossier> typesdossiers;
       @Autowired
       private BureauRepository bureauRepository;
       @Autowired
       private TransmissionRepository transmissionRepository;
	private BufferedWriter i;
  
  
   	@RequestMapping(value="/affichagestatistique",method = RequestMethod.GET )
   	public String redirection(Model model,@RequestParam(name="status") String status,@RequestParam(name="typedossier") String typedossier,
   			@RequestParam(name="dateReception") String dd,@RequestParam(name="dateTransmission") String df) throws ParseException, IOException{
   		typesdossiers = dossierRepository.findAll();
   		model.addAttribute("l_typedocs",typesdossiers);
   		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date d,f =null;
			d = formater.parse(dd);
			f = formater.parse(df);			
//				typedossier="";

				List<Transmission> l_statistiques = transmissionRepository.findStatistique(status,"%"+typedossier+"%", d, f);
		   		model.addAttribute("statistiques",l_statistiques);
//		   		int cpt=0;
//	            for (Transmission transmission : l_statistiques) {
//	            	cpt++;				
//				}
//	            System.out.println(cpt+" Dossier(s) trvouvé(s)");
//		   		System.out.println("Taille de la liste"+"-"+l_statistiques.size());
		   		File file = new File("statistiques.csv");
		   		file.createNewFile();
		   		FileWriter writer = new FileWriter(file);
		      
		   		for (Transmission transmission : l_statistiques) {
		   			writer.write(transmission.getDossierClient().getNom()+"\t "+ transmission.getDossierClient().getMatricule()+" "+
		   		transmission.getDateReception()+" "+transmission.getDateTransmission()+" "+transmission.getStatus()+" \t "+transmission.getObservation()+"\n"); 
				}
		   	  writer.flush();
		        writer.close();
		   		
   		return "controle";
       }
   		
}
