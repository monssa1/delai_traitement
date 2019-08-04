package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.DossierClientRepository;
import com.example.demo.dao.EmployeRepository;
import com.example.demo.dao.TransmissionRepository;
import com.example.demo.entities.Employe;
import com.example.demo.entities.Transmission;
import com.example.demo.metier.ITraitemantMetier;

@SpringBootApplication
public class SpringbootGtsprvApplication implements CommandLineRunner{
	@Autowired
	private EmployeRepository employeRepository ;
	@Autowired
	private DossierClientRepository dossierClientRepostry;
	@Autowired
	private ITraitemantMetier iTraitemantMetier;
	@Autowired
	private TransmissionRepository tr;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGtsprvApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
	//employeRepository.save(new Employe(null, "mXT01", "camara", "elycheikh",null));
		//iTraitemantMetier.AddDossier("test01", "diouf", "moussa");
//		 SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		Date d= formater.parse("2018-01-01");
//		Date f= formater.parse("2018-12-11");
//		String typedoc="PENSION";
//		List<Transmission> liste=tr.findStatistique("valider",typedoc,d,f);
//		for (Transmission transmission : liste) {
//			System.out.println(transmission.getId());
			
		//}
	}
}
