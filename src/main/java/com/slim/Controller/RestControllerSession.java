package com.slim.Controller;

import java.util.ArrayList;
import java.util.Collection;
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
import com.slim.Domain.Session;
import com.slim.Domain.Soutenance;
import com.slim.Dto.SessionDTO;
import com.slim.Repository.ISession;
import com.slim.Repository.ISoutenance;
import com.slim.service.implementation.SessionService;


@RestController

@CrossOrigin(origins="*")
@RequestMapping("api/session")
public class RestControllerSession {
	@Autowired
	SessionService SessionService;
	@Autowired
	ISession reposession;
	@Autowired
	ISoutenance soutenancerepo;
	static final Logger logger = Logger.getLogger(RestControllerSession.class);

	@PostMapping(value = "/create")
	public 	void addSession(@RequestBody Session Session) {
		try {
			SessionService.create(Session);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addsalle(Model model, @RequestBody Session session )
	 {
		System.out.println("atr1"+session.getDatefinestimee());
		Session s = new Session();

		Session se = new Session();
		se=this.reposession.save(session);
	
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	@RequestMapping(value = "/updatesession", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> updatesession(Model model, @RequestBody Session session )
	 {
	
		System.out.println("atr1"+session.getDatefinestimee());
		Session s = new Session();
		s=this.reposession.findOne(session.getIdsession());
		Session se = new Session();
		se=this.reposession.save(session);
	
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> usernames) {
		Session objectToDelete ;
		Soutenance soutenance;
		List<Soutenance> list= new ArrayList<>();
		try {
			//System.out.println(usernames.size());
			for(int i=0; i<usernames.size();i++) {
				objectToDelete = null;
				soutenance =null;
				System.out.println(usernames.get(i));
				objectToDelete = reposession.findOne(usernames.get(i));
				if(objectToDelete!=null) 
					System.out.println(usernames.get(i)+"slimyabhim");
				 list  =this.soutenancerepo.findBySession(objectToDelete);
				 for(int j=0 ;j<list.size();j++) {
					 soutenancerepo.delete(list.get(j));
				 }
				
				reposession.delete(objectToDelete);
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
	@PutMapping(value = "/update")
	public 	void updateSession(@RequestBody Session Session) {
		try {
			SessionService.update(Session);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Session getSession(@PathVariable("id") Integer id) {
		Session Session = null;
		try {
			Session = SessionService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Session;
	}

	@GetMapping(value = "/all")
	public 	List<Session> getSalle() {

		List<Session> SessionList = null;
		try {
			SessionList = this.reposession.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SessionList;
	}
	@RequestMapping(value = "/allsession", method = RequestMethod.GET)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	public Collection<Session> getAllSession() {
	
		
		return this.reposession.findAll();

}

	
}
