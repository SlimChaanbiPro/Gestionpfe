package com.slim.Domain;

public enum TypeEnseignant {
	Enseignant_President("ChefJury"),
	Enseignant_Encadrant("Encadrant"),
	Enseignant_Rapporteur("Rapporteur");

	private  String type; 
	
	TypeEnseignant(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
