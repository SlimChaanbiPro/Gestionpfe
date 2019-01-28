package com.slim.service.implementation;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.slim.Domain.Enseignent;
import com.slim.Domain.Salle;
import com.slim.Dto.EnseignantDTO;
import com.slim.Dto.SalleDTO;


public class MainController {
	
	static final int ZERO = 0;
	static final int UN = 1;
	static final int DEUX = 2;
	static final int TROIS = 3;
	static final int QUATRE = 4;
	static final int CINQ = 5;
	static final int SIX = 6;
	static final int SEPT = 7;
	static final int HUIT = 8;
	
	@Autowired
	public ModelMapper modelMapper;
	
	
	
	//*************Convert Entity To DTO (DATA TRANSFERT OBJECT)*****************************
	
	

	public SalleDTO convertSalleToDto(Salle entity) {
		SalleDTO entityDto = modelMapper.map(entity, SalleDTO.class);
		return entityDto;
	}
	public EnseignantDTO convertEnseignentToDto(Enseignent entity) {
		EnseignantDTO entityDto = modelMapper.map(entity, EnseignantDTO.class);
		return entityDto;
	}

	
	// *****************Convert DTO (DATA TRANSFERT OBJECT ) to Entity**********************************
	
	
	public Salle dtoToSalle(SalleDTO Dto) {
		Salle entity = modelMapper.map(Dto, Salle.class);
		return entity;
	}
	public Enseignent dtoToEnseigant(EnseignantDTO Dto) {
		Enseignent entity = modelMapper.map(Dto, Enseignent.class);
		return entity;
	}
	
	
	
	

}
