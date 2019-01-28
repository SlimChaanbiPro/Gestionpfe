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

import com.slim.Domain.FichePFE;
import com.slim.Domain.Optionnal;
import com.slim.Dto.OptionDTO;
import com.slim.Dto.SalleDTO;
import com.slim.Repository.IOption;
import com.slim.service.implementation.OptionService;




@RestController
@RequestMapping("api/option")
@CrossOrigin(origins="*")


public class RestControllerOption {
	@Autowired
	OptionService OptionService;
	@Autowired
	IOption optionrepo;
	static final Logger logger = Logger.getLogger(RestControllerOption.class);


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_Admin')")
	 public @ResponseBody Map<String, Boolean> addoption(Model model, @RequestBody OptionDTO Option)
	 {
		Optionnal op = new Optionnal();
		op.setDescription(Option.getDescription());
		op.setType(Option.getType());
		OptionService.create(op);
	
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		
		
		return success;
	 }
	@DeleteMapping(value = "/delete")
	public 	void delOption(@RequestBody Integer id) {
	Optionnal 	Option = OptionService.findbyid(id);
		try {
			OptionService.delete(Option);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	@PutMapping(value = "/update")
	public 	void updateOption(@RequestBody Optionnal Option) {
		try {
			OptionService.update(Option);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Optionnal getOption(@PathVariable("id") Integer id) {
		Optionnal Option = new Optionnal();
		try {
			Option = OptionService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Option;
	}

	@GetMapping(value = "/list")
	public 	List<Optionnal> getOption() {

		List<Optionnal> OptionList = null;
		try {
			OptionList = OptionService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return OptionList;
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<Integer> listid) {
		Optionnal objetcToDelete ;
		
		try {
			//System.out.println(listid.size());
			for(int i=0; i<listid.size();i++) {
				objetcToDelete = null;
				System.out.println(listid.get(i));
				objetcToDelete = optionrepo.findOne(listid.get(i));
				if(objetcToDelete!=null) 
					System.out.println(listid.get(i)+"slimyabhim");
				optionrepo.delete(objetcToDelete);
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

