package com.slim.Controller;

import java.util.Calendar;
import java.util.Date;
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

import com.slim.Domain.Enseignent;
import com.slim.Domain.Optionnal;
import com.slim.Domain.Salle;
import com.slim.Domain.Soutenance;
import com.slim.Dto.SoutenanceDTO;
import com.slim.Repository.IEnseignent;
import com.slim.Repository.ISalle;
import com.slim.Repository.ISession;
import com.slim.Repository.ISoutenance;
import com.slim.service.implementation.SoutenanceService;





@RestController
@RequestMapping("api/soutenance")
@CrossOrigin(origins="*")
public class RestControllerSoutenance {
	@Autowired
	//SoutenanceService SoutenanceService;
	SoutenanceService SoutenanceService ;
	@Autowired
	IEnseignent enserepo;
	
	@Autowired
	ISoutenance soutenancerepo;
	@Autowired 
	ISalle sallerepo ;
	@Autowired 
	ISession sessionrepo ;
	
	static final Logger logger = Logger.getLogger(RestControllerSoutenance.class);
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> addGroupe(Model model, @RequestBody SoutenanceDTO soutenance) {
		try {
			Soutenance s = new Soutenance();
			s.setDatedebut(soutenance.getDatedebut());
			s.setDatefinestimee(soutenance.getDatefinestimee());
			s.setDescription(soutenance.getDescription());
			Salle salle = this.sallerepo.findOne(soutenance.getIdsalle());
			Enseignent enseignant =this.enserepo.findOne(soutenance.getId_user());
			s.setEnseignent(this.enserepo.findOne(soutenance.getId_user()));
			s.setSalle(this.sallerepo.findOne(soutenance.getIdsalle()));
			s.setSession(this.sessionrepo.findOne(soutenance.getIdsession()));
			  Calendar calendar = Calendar.getInstance();
			  
			     calendar.setTime(soutenance.getDatedebut());
			     int y = calendar.get(Calendar.YEAR);
			     int m =calendar.get(Calendar.MONTH);
			     int day =calendar.get(Calendar.DAY_OF_MONTH);
s.setDateSoutenance("Session    \n  : "+ s.getSession().getDescription()+" DANS LA DATE  \n  : "+y+"-"
			     +m+"-"+"-"+day+
		
		
		" [ et lheure de debut soit : \n]"+soutenance.getDateSoutenancebegin()+"et l'heur de fin est :"+soutenance.getDateSoutenanceEnd()
		
		+"\n le president du jury est : \n "+s.getEnseignent().getNom() +","+s.getEnseignent().getPrenom()
		
		+" \n la soutenance devra etre da ns la salle :\n"+s.getSalle().getNomSalle()
		);
			soutenancerepo.save(s);
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
	@PostMapping(value = "/create")
	public 	void addSoutenance(@RequestBody Soutenance Soutenance) {
		try {
			SoutenanceService.create(Soutenance);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	
	@DeleteMapping(value = "/delete")
	public 	void delSoutenance(@RequestBody Soutenance Soutenance) {
		try {
			SoutenanceService.delete(Soutenance);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	@PutMapping(value = "/update")
	public 	void updateSoutenance(@RequestBody Soutenance Soutenance) {
		try {
			SoutenanceService.update(Soutenance);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Soutenance getSoutenance(@PathVariable("id") Integer id) {
		Soutenance Soutenance = null;
		try {
			Soutenance = SoutenanceService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Soutenance;
	}

	@GetMapping(value = "/list")
	public 	List<Soutenance> getSoutenance() {

		List<Soutenance> SoutenanceList = null;
		try {
			SoutenanceList = SoutenanceService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SoutenanceList;
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> listid) {
		Soutenance objetcToDelete ;
		
		try {
			//System.out.println(listid.size());
			for(int i=0; i<listid.size();i++) {
				objetcToDelete = null;
				System.out.println(listid.get(i));
				objetcToDelete = soutenancerepo.findOne(listid.get(i));
				if(objetcToDelete!=null) 
					System.out.println(listid.get(i)+"slimyabhim");
				soutenancerepo.delete(objetcToDelete);
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
