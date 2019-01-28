package com.slim.Domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Departements {
	
	private Integer iddepartement;
	private String libelle;
	//private Set<Enseignent> enseignants = new HashSet<Enseignent>();
	
	private List<Enseignent> enseignants ;
	
	public Departements(Integer iddepartement, String libelle, List<Enseignent> enseignants) {
		super();
		this.iddepartement = iddepartement;
		this.libelle = libelle;
		this.enseignants = enseignants;
		
		
	}
	
	 
	    
	public Departements(String libelle) {
		super();
		this.libelle = libelle;
	}



	@OneToMany(mappedBy = "departement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JsonManagedReference
	public List<Enseignent> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(List<Enseignent> enseignants) {
		this.enseignants = enseignants;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iddepartement", unique = true, nullable = false)
	public Integer getIddepartement() {
		return iddepartement;
	}
	public void setIddepartement(Integer iddepartement) {
		this.iddepartement = iddepartement;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
	
	
	
	
	
	
	public Departements() {
		
	}
	public Departements(Integer iddepartement, String libelle) {
		super();
		this.iddepartement = iddepartement;
		this.libelle = libelle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enseignants == null) ? 0 : enseignants.hashCode());
		result = prime * result + ((iddepartement == null) ? 0 : iddepartement.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departements other = (Departements) obj;
		if (enseignants == null) {
			if (other.enseignants != null)
				return false;
		} else if (!enseignants.equals(other.enseignants))
			return false;
		if (iddepartement == null) {
			if (other.iddepartement != null)
				return false;
		} else if (!iddepartement.equals(other.iddepartement))
			return false;
		return true;
	}
	

	
	
}
