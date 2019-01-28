package com.slim.Domain;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Entreprise {
	
	
	
	
	private Integer idEntreprise;
	private String nom;
	//private Enseignant enseignant;
	private String mail;
	private String address;
	
	
	
	
	/*@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public Set<Enseignent> getEnseignants() {
		return enseignants;
	}*/

	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
    public Enseignant getUser() {
		return enseignant;
	}*/

	/*public void setUser(Enseignant enseignant) {
		this.enseignant = enseignant;
	}*/

	

	

	
	
	
	
	public Entreprise() {
		
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idetreprise", unique = true, nullable = false)
	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
