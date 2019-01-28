package com.slim.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slim.Domain.Etudiant;
import com.slim.service.implementation.EtudiantService;


@RestController
@RequestMapping("/Etudiant")
@CrossOrigin(origins="*")
public class RestcontrollerEtudiant {
	
	@Autowired
	EtudiantService EtudiantService;

	static final Logger logger = Logger.getLogger(RestcontrollerEtudiant.class);

	@PostMapping(value = "/create")
	public 	void addEtudiant(@RequestBody Etudiant Etudiant) {
		try {
			EtudiantService.create(Etudiant);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	
	@DeleteMapping(value = "/delete")
	public 	void delEtudiant(@RequestBody Etudiant Etudiant) {
		try {
			EtudiantService.delete(Etudiant);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}
	@PutMapping(value = "/update")
	public 	void updateEtudiant(@RequestBody Etudiant Etudiant) {
		try {
			EtudiantService.update(Etudiant);
			
		} catch (Exception e) {
			 e.printStackTrace();
			
		}

	}

	@GetMapping(value = "/{id}")
	public 	Etudiant getEtudiant(@PathVariable("id") Integer id) {
		Etudiant Etudiant = null;
		try {
			Etudiant = EtudiantService.findbyid(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Etudiant;
	}

	@GetMapping(value = "/list")
	public 	List<Etudiant> getEtudiant() {

		List<Etudiant> EtudiantList = null;
		try {
			EtudiantList = EtudiantService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return EtudiantList;
	}


}
