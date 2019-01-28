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
import com.slim.Domain.Enseignent;
import com.slim.Dto.DepartementsDTO;
import com.slim.Repository.IDepartement;
import com.slim.Repository.IEnseignent;
import com.slim.service.implementation.DepartementService;






@RestController
@RequestMapping("api/departements")
@CrossOrigin(origins="*")
public class RestControllerDepartement {
	@Autowired
	DepartementService departementService;
	@Autowired
	IEnseignent enserepo;
	@Autowired
	IDepartement deprepo;
	static final Logger logger = Logger.getLogger(RestControllerDepartement.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public 	void addDepartements( Model model, @RequestBody DepartementsDTO departements) {
		
		
		//d.setLibelle(departement);
	Departements d = new Departements();
	d.setLibelle(departements.getLibelle());
			deprepo.save(d);
			
			
			
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void  delDepartements(Model model, @RequestBody Integer id) {
		
		System.out.println("idddddddddddddddddddddddddddd"+id);
		try {
			System.out.println("idddddddddddddddddddddddddddd"+id);
		Departements d =	departementService.findbyid(id);
			departementService.delete(id);
	
			
			
			
		} catch (Exception e) {
			
			 e.printStackTrace();
			
		}
		
	}
	@PutMapping(value = "/update")
	public 	void updateDepartements(@RequestBody Departements Departements) {
		try {
			departementService.update(Departements);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Departements getDepartements(@PathVariable("id") Integer id) {
		Departements Departements = null;
		try {
			Departements = departementService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Departements;
	}

	@GetMapping(value = "/list")
	public 	List<Departements> getDepartements() {

		List<Departements> DepartementsList = null;
		try {
			DepartementsList = departementService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return DepartementsList;
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> listid) {
		Departements objecttodelete ;
		List<Enseignent >ense;
		try {
			//System.out.println(listid.size());
			for(int i=0; i<listid.size();i++) {
				objecttodelete = null;
				ense=null;
				System.out.println(listid.get(i));
			//	Enseignant = enserepo.findOne(null);
				objecttodelete = deprepo.findOne(listid.get(i));
				
				if(objecttodelete!=null) 
					 ense = (List<Enseignent>) enserepo.findOne(objecttodelete.getIddepartement());
				if(ense!=null) {
				for(int j =0 ;j<ense.size();j++) {
					ense.get(j).setDepartement(null);	
					ense.get(j).setDepartementEnseignant("Aucun departement");
					enserepo.save(ense.get(j));
					
				}}
				
					System.out.println(listid.get(i)+"slimyabhim");
				deprepo.delete(objecttodelete);
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
