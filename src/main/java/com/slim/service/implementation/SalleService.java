package com.slim.service.implementation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Salle;
import com.slim.Dto.SalleDTO;
import com.slim.Repository.SalleRepository;


@Service

public class SalleService extends MainController   {
	

	SalleDTO salleDTO = null ;
	@Autowired
	SalleRepository sallerepository ;
//*************** Adding Salle *******
	
	public SalleDTO save(SalleDTO salleDTO) {
		
		Salle s = dtoToSalle(salleDTO);
		Salle sallecreated = this.sallerepository.save(s);
		return convertSalleToDto(sallecreated);
	}
	//******* update salle **************************
	public SalleDTO update(Salle salleDTO) {
			Salle sallecreated = this.sallerepository.save(salleDTO);
		return convertSalleToDto(sallecreated);
	}

//******** find salle by id ********
	public SalleDTO findOne(Long id) {
	Salle s = this.sallerepository.findOne(id);
	SalleDTO salle = convertSalleToDto(s);
		return salle;
	}
	//*************** recherche salle par son nom et retourne l'objet DTO trouvé ******
	public SalleDTO findByNomSalle(String nomSalle){
	Salle s = this.sallerepository.findByNomSalle(nomSalle);
	SalleDTO salle = convertSalleToDto(s);
	
		return salle;
	}
	//*************** recherche salle par son nom et retourne l'objet  trouvé ******
	public Salle findByNomSalles(String nomSalle){
	Salle s = this.sallerepository.findByNomSalle(nomSalle);
	return s;
	}
// DELETE SALLE SELECTIONNEE
	
	public void delete( Salle salletodelete) {
		this.sallerepository.delete(salletodelete);
	}
	// FONCTION QUI RETOURNE UNE LISTE DES SALLES 
	public Collection<SalleDTO> findAll() {

		return this.sallerepository.findAll().stream().map(entity -> convertSalleToDto(entity)).collect(Collectors.toList());
	
	}


}
