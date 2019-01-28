package com.slim.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.slim.Domain.Authority;
import com.slim.Domain.Departements;
import com.slim.Domain.Enseignent;
import com.slim.Domain.Utilisateur;
import com.slim.Dto.EnseignantDTO;
import com.slim.Dto.SalleDTO;
import com.slim.Repository.IDepartement;
import com.slim.Repository.IEnseignent;
import com.slim.service.implementation.EnseignentService;
import com.slim.service.implementation.MainController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@EnableWebMvc
@Configuration
@ComponentScan
@RestController
@RequestMapping("api/enseignant")
@CrossOrigin(origins="*")
public class RestControllerEnseignent {
	@Autowired
	EnseignentService EnseignentService;
	@Autowired
	IEnseignent ienseignet;
	@Autowired
	IDepartement idepartement;
	
MainController maincontroller ;
	static final Logger logger = Logger.getLogger(RestControllerEnseignent.class);

	
	/*
	@PostMapping(value = "/create")
	public 	void addEnseignent(@RequestBody Enseignent Enseignent) {
		try {
			EnseignentService.create(Enseignent);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}
		
	}
	*/
		 

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ADMIN')")
	public  @ResponseBody Map<String, Boolean> adduser(Model model , @RequestBody Enseignent user ) {
		Boolean response;
		try {
			System.out.println(user.getDepartementEnseignant());
			String departement = user.getDepartementEnseignant();
			Departements dep = idepartement.findByLibelle(departement);
			user.setDepartement(dep);
			
			
			ienseignet.save(user);
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
		
		
	}
	 
		
		 

	
	
	@DeleteMapping(value = "/delete")
	public 	Boolean delEnseignent(@RequestBody Enseignent Enseignent) {
		try {
			EnseignentService.delete(Enseignent);
			return true;
			
			
		} catch (Exception e) {
			 e.printStackTrace();
			 return false;
			
		}
		
		

	}
	
	/*@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public boolean suprimer(@PathVariable Integer id ){
		
		ienseignet.delete(id);
		 return true ;
	}*/
	@PutMapping(value = "/update")
	public 	void updateEnseignent(@RequestBody Enseignent Enseignent) {
		try {
			EnseignentService.update(Enseignent);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Enseignent getEnseignent(@PathVariable("id") Integer id) {
		Enseignent Enseignent = null;
		try {
			Enseignent = EnseignentService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Enseignent;
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public @ResponseBody List<Enseignent> getalluser(Model model) {
		return ienseignet.findAll();
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> usernames) {
		Enseignent utilisateurtodelete ;
		
		try {
			//System.out.println(usernames.size());
			for(int i=0; i<usernames.size();i++) {
				utilisateurtodelete = null;
				System.out.println(usernames.get(i));
				utilisateurtodelete = ienseignet.findOne(usernames.get(i));
				if(utilisateurtodelete!=null) 
					System.out.println(usernames.get(i)+"slimyabhim");
				ienseignet.delete(utilisateurtodelete);
				System.out.println(usernames.get(i)+"slimyabhim1");
			
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
	
}
