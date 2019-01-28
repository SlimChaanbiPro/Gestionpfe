package com.slim.Controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slim.Domain.Enseignent;
import com.slim.Domain.Soutenance;
import com.slim.Domain.ValidationTechnique;
import com.slim.Dto.SalleDTO;
import com.slim.Dto.ValidationDTO;
import com.slim.Dto.ValidationTechniqueDTO;
import com.slim.Repository.IEnseignent;
import com.slim.Repository.IValidationTechnique;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/validation")
public class ValidationController {
	
	@Autowired
	IValidationTechnique validationrepo; 
	@Autowired
	IEnseignent enserepo;
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addValidation(Model model, @RequestBody ValidationTechniqueDTO validtiondto )
	 {
		ValidationTechnique v = new ValidationTechnique();
		v.setDatevalidation(validtiondto.getDatevalidation());
		v.setFiche(validtiondto.getFiche());
		v.setRapporteur(validtiondto.getRapporteur());
		v.setDescription(validtiondto.getDescription());
		ValidationTechnique va = this.validationrepo.save(v);

	System.out.println(va);
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Collection<ValidationTechnique> getAllValidation() {
		return this.validationrepo.findAll();

}
	
	@RequestMapping(value = "/affecterrapporteur", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addrapporteur(Model model,@RequestBody ValidationDTO validation )
	 {
		ValidationTechnique v = new ValidationTechnique();
		Enseignent e = this.enserepo.findOne(validation.getIdrapporteur());
		v=this.validationrepo.findOne(validation.getId());
		v.setRapporteur(e);
		ValidationTechnique va = this.validationrepo.save(v);

	System.out.println(va);
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	@RequestMapping(value = "/addnoteencadrant", method = RequestMethod.POST,consumes = "application/json")
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addnoteencadrant(Model model, @RequestBody ValidationDTO validation)
	 {
		ValidationTechnique v = new ValidationTechnique();
	//	Enseignent e = this.enserepo.findOne(idencadrent);
		v=this.validationrepo.findOne(validation.getId());
		v.setNotencadrant(validation.getNoteencadrent());
		ValidationTechnique va = this.validationrepo.save(v);

	System.out.println(va);
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	@RequestMapping(value = "/addnoterapporteur", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addnoterapporteur(Model model, @RequestBody ValidationDTO validation )
	 {
		ValidationTechnique v = new ValidationTechnique();
	//	Enseignent e = this.enserepo.findOne(idencadrent);
		v=this.validationrepo.findOne(validation.getId());
		v.setNote(validation.getNoterapporteur());
		ValidationTechnique va = this.validationrepo.save(v);

	System.out.println(va);
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	@RequestMapping(value = "/getvalidationbyrapporteur", method = RequestMethod.GET )
	public   @ResponseBody Long getvalidationbyrapporteur(Integer idrapporteur ) throws ParseException {
		
		ValidationTechnique v = new ValidationTechnique();
		Enseignent e = this.enserepo.findOne(idrapporteur);


		List<ValidationTechnique> l =this.validationrepo.findByRapporteur(e);
		
Long a = (long) l.size();
	
			return	a;

	
	
	}
	
	
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Long> listid) {
		ValidationTechnique objetcToDelete ;
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		try {
			//System.out.println(listid.size());
			for(int i=0; i<listid.size();i++) {
				objetcToDelete = null;
				System.out.println(listid.get(i));
				objetcToDelete = validationrepo.findOne(listid.get(i));
				if(objetcToDelete!=null) 
				validationrepo.delete(objetcToDelete);
			
			}
			
			
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
