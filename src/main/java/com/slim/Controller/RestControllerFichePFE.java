package com.slim.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slim.Domain.Entreprise;
import com.slim.Domain.FichePFE;
import com.slim.Dto.SalleDTO;
import com.slim.Repository.IFichePFE;
import com.slim.service.implementation.FichePFEService;





@RestController
@RequestMapping("api/fiche")
@CrossOrigin(origins="*")
public class RestControllerFichePFE {
	@Autowired
	FichePFEService FichePFEService;
	@Autowired
	IFichePFE listefiche;

	
	

	@RequestMapping(value="/chercherfiches",method=RequestMethod.GET)
public Page<FichePFE> chercher(
			@RequestParam(name="mc",defaultValue="") String mc ,
			
			@RequestParam(name="page",defaultValue="0") int page ,
		@RequestParam(name="size",defaultValue="5") int size
			){
		
		return listefiche.chercher("%"+mc+"%", new PageRequest(page,size));
	}
	
	static final Logger logger = Logger.getLogger(RestControllerFichePFE.class);

	@PostMapping(value = "/create")
	public 	void addFiche(@RequestBody FichePFE FichePFE) {
		try {
			FichePFEService.create(FichePFE);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	
	@DeleteMapping(value = "/delete")
	public 	void delfiche(@RequestBody FichePFE FichePFE) {
		try {
			FichePFEService.delete(FichePFE);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	@PutMapping(value = "/update")
	public 	void updatefiche(@RequestBody FichePFE FichePFE) {
		try {
			FichePFEService.update(FichePFE);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	FichePFE getfiche(@PathVariable("id") Integer id) {
		FichePFE FichePFE = null;
		try {
			FichePFE = FichePFEService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return FichePFE;
	}

	@GetMapping(value = "/list")
	public 	List<FichePFE> getfiche() {

		List<FichePFE> FichePFEList = null;
		try {
			FichePFEList = FichePFEService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return FichePFEList;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	public Collection<FichePFE> getAllclient() {
		return this.FichePFEService.findAll();

}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> listid) {
		FichePFE objetcToDelete ;
		
		try {
			//System.out.println(listid.size());
			for(int i=0; i<listid.size();i++) {
				objetcToDelete = null;
				System.out.println(listid.get(i));
				objetcToDelete = listefiche.findOne(listid.get(i));
				if(objetcToDelete!=null) 
					System.out.println(listid.get(i)+"slimyabhim");
				listefiche.delete(objetcToDelete);
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
