package com.slim.Domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idsession;
	private Date datedebut;
	private Date datefinestimee;
	private String Description;
	@OneToMany(mappedBy = "session")
	private List<Soutenance> soutenances ;
	@OneToMany(mappedBy = "sessions")
	private List<Etudiant> etudiants ;
	
	
	

	
	
	
	
	@JsonIgnore
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


	public Session(Integer idsession, Date datedebut, Date datefinestimee, String description,
			List<Soutenance> soutenances, List<Etudiant> etudiant) {
		super();
		this.idsession = idsession;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		this.soutenances = soutenances;
		this.etudiants = etudiant;
	}
	
	@JsonIgnore
	public List<Etudiant> getEtudiant() {
		return etudiants;
	}
	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiants = etudiant;
	}
	@JsonIgnore
	public List<Soutenance> getSoutenances() {
		return soutenances;
	}
	public void setSoutenances(List<Soutenance> soutenances) {
		this.soutenances = soutenances;
	}
	public Session(Integer idsession, Date datedebut, Date datefinestimee, String description, 
			List<Soutenance> soutenances) {
		super();
		this.idsession = idsession;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		
		this.soutenances = soutenances;
	}
	

	public Integer getIdsession() {
		return idsession;
	}
	public void setIdsession(Integer idsession) {
		this.idsession = idsession;
	}
	

	
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefinestimee() {
		return datefinestimee;
	}
	public void setDatefinestimee(Date datefinestimee) {
		this.datefinestimee = datefinestimee;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	

}
