package com.slim.Controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slim.Domain.Departements;
import com.slim.Domain.Entreprise;
import com.slim.Repository.IEntreprise;
import com.slim.service.implementation.EntrepriseService;
@RestController
@RequestMapping("api/entreprise")
@CrossOrigin(origins="*")
public class RestControllerEntreprise {
	@Autowired
	EntrepriseService EntrepriseService;
	@Autowired
	IEntreprise entrepriserepo ;
	static final Logger logger = Logger.getLogger(RestControllerEntreprise.class);

	@PostMapping(value = "/add")
	public 	void addEntreprise(@RequestBody Entreprise Entreprise) {
		Entreprise en = this.entrepriserepo.findByNom(Entreprise.getNom());
		if (en==null) {
		try {
			EntrepriseService.create(Entreprise);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
		
		}
	
	@DeleteMapping(value = "/delete")
	public 	void delEntreprise(@RequestBody Entreprise Entreprise) {
		try {
			
			EntrepriseService.delete(Entreprise);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	@PutMapping(value = "/update")
	public 	void updateEntreprise(@RequestBody Entreprise Entreprise) {
		try {
			EntrepriseService.update(Entreprise);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Entreprise getEntreprise(@PathVariable("id") Integer id) {
		Entreprise Entreprise = null;
		try {
			Entreprise = EntrepriseService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Entreprise;
	}

	@GetMapping(value = "/all")
	public 	List<Entreprise> getEntreprise() {

		List<Entreprise> EntrepriseList = null;
		try {
			EntrepriseList = EntrepriseService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return EntrepriseList;
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> listid) {
		Entreprise objetcToDelete ;
		
		try {
			//System.out.println(listid.size());
			for(int i=0; i<listid.size();i++) {
				objetcToDelete = null;
				System.out.println(listid.get(i));
				objetcToDelete = entrepriserepo.findOne(listid.get(i));
				if(objetcToDelete!=null) 
					System.out.println(listid.get(i)+"slimyabhim");
				entrepriserepo.delete(objetcToDelete);
				System.out.println(listid.get(i)+"slimyabhim1");
			
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
