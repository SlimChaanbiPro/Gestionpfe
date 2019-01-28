package com.slim.Domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slim.file.model.FileModel;

@Entity
public class FichePFE {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idfiche;

	private String titre;
	private String description;
	private Boolean valide;
	@OneToOne
	
	private FileModel rapport ;
	 private Boolean depotrapport;
	 
	@OneToOne
	@JsonIgnore
	private Etudiant etudiant;
	
	
		
	
	
	
	

	
	

	
	

	public FileModel getRapport() {
		return rapport;
	}

	public void setRapport(FileModel rapport) {
		this.rapport = rapport;
	}

	public Boolean getDepotrapport() {
		return depotrapport;
	}

	public void setDepotrapport(Boolean depotrapport) {
		this.depotrapport = depotrapport;
	}

	public FichePFE(Integer idfiche, String titre, String description, Boolean valide, Etudiant etudiant) {
		super();
		this.idfiche = idfiche;
		titre = titre;
		this.description = description;
		this.valide = valide;
		this.etudiant = etudiant;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public FichePFE(Integer idfiche, String titre, String description, Boolean valide) {
		super();
		this.idfiche = idfiche;
		//this.enseignants = enseignants;
		titre = titre;
		this.description = description;
		this.valide = valide;
	}
	public FichePFE() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getIdfiche() {
		return idfiche;
	}
	public void setIdfiche(Integer idfiche) {
		this.idfiche = idfiche;
	}
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getValide() {
		return valide;
	}
	public void setValide(Boolean valide) {
		this.valide = valide;
	}

	public FichePFE(Integer idfiche, String titre, String description, Boolean valide, FileModel rapport,
			Boolean depotrapport, Etudiant etudiant) {
		super();
		this.idfiche = idfiche;
		this.titre = titre;
		this.description = description;
		this.valide = valide;
		this.rapport = rapport;
		this.depotrapport = depotrapport;
		this.etudiant = etudiant;
	}

	
}
