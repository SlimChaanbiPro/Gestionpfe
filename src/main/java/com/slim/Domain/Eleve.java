package com.slim.Domain;

import java.io.Serializable;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author slim
 *
 */
@Entity

public class Eleve implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id ;
	private String numInscription;
	private String  nom;
	private String prenom ;
	private String remarque ;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance ;
	@Temporal(TemporalType.DATE)
	private  Date dateInscription ;
	private String etat ;
	private String sexe ;
	private String situationFamiliale ;
	private String photo ;
	private String niveauEtude ; 
	private Long cin ;
	private String classeActuel ;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNumInscription() {
		return numInscription;
	}
	public void setNumInscription(String numInscription) {
		this.numInscription = numInscription;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public String getClasseActuel() {
		return classeActuel;
	}
	public void setClasseActuel(String classeActuel) {
		this.classeActuel = classeActuel;
	}
	public Eleve(Long id, String numInscription, String nom, String prenom, String remarque, Date dateNaissance,
			Date dateInscription, String etat, String sexe, String situationFamiliale, String photo, String niveauEtude,
			Long cin, String classeActuel) {
		super();
		Id = id;
		this.numInscription = numInscription;
		this.nom = nom;
		this.prenom = prenom;
		this.remarque = remarque;
		this.dateNaissance = dateNaissance;
		this.dateInscription = dateInscription;
		this.etat = etat;
		this.sexe = sexe;
		this.situationFamiliale = situationFamiliale;
		this.photo = photo;
		this.niveauEtude = niveauEtude;
		this.cin = cin;
		this.classeActuel = classeActuel;
	}
	public Eleve() {
		super();
	}


	
	
	
	
	
}
