package com.slim.Dto;

import java.util.Date;

import lombok.Data;


public class DepartementsDTO {
	private String libelle ;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DepartementsDTO(String libelle) {
		super();
		this.libelle = libelle;
	}

	public DepartementsDTO() {
		super();
	}
	

}
