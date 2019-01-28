package com.slim.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slim.Domain.Salle;
import com.slim.Domain.Utilisateur;
import com.slim.Dto.SalleDTO;
import com.slim.Repository.SalleRepository;
import com.slim.service.implementation.SalleService;

/**
 * @author slim
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/salle")
public class SalleController {
	
	@Autowired
	SalleService salleservice ; 
	@Autowired
	SalleRepository sallerepository ;
	
	
	
	
	
	
	
	//*******************Create new Salle******************* 
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addsalle(Model model, @RequestBody SalleDTO salledto )
	 {
	SalleDTO a = salleservice.save(salledto);
	System.out.println(a);
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	//********************** get all salle *************************
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	public Collection<SalleDTO> getAllclient() {
		return this.salleservice.findAll();

}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	public Collection<Salle> getallsallle() {
		return this.sallerepository.findAll();

}

	
	//*************************** remove Salle ****************************
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<String> nomSalle) {
		Salle salletodelete ;
		System.out.println("listedebut");
		System.out.println(nomSalle);
		System.out.println("listefin");
		try {
			//System.out.println(usernames.size());
			for(int i=0; i<nomSalle.size();i++) {
				salletodelete = null;
				System.out.println(nomSalle.get(i)+"slimyabhim1");
				System.out.println(nomSalle.get(i));
				salletodelete = salleservice.findByNomSalles(nomSalle.get(i));
				System.out.println(nomSalle.get(i)+"slimyabhim111");
				if(salletodelete!=null) 
				//	System.out.println(nomSalle.get(i)+"slimyabhim4141");
					salleservice.delete(salletodelete);
					//System.out.println(nomSalle.get(i)+"slimyab14552him1");
			}
			
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}
	
	//**********************update Salle ******************************************
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> updatesalle(Model model, @RequestBody SalleDTO salle) {
	
		Salle s = salleservice.findByNomSalles(salle.getNomSalle());
		
		
		if(s!=null) {
			s.setType(salle.getType());
			s.setRemarque(salle.getRemarque());
			
			
		 try {
			 this.salleservice.update(s);
			 Map<String, Boolean> success = new TreeMap<String, Boolean>();
				success.put("response", true);
				return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
		}else {
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}
	

}
