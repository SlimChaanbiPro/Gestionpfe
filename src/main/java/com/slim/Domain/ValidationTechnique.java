package com.slim.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ValidationTechnique {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private    Long id ;
	@ManyToOne
	private Enseignent rapporteur ;
	private Float note ;
	private Float notencadrant ;
	private String description ; 
	@ManyToOne
	private FichePFE fiche ;
	private Date datevalidation;
	public Long getId() {
		return id;
	}
	
	public ValidationTechnique(Long id, Enseignent rapporteur, Float note, Float notencadrant, String description,
			FichePFE fiche, Date datevalidation) {
		super();
		this.id = id;
		this.rapporteur = rapporteur;
		this.note = note;
		this.notencadrant = notencadrant;
		this.description = description;
		this.fiche = fiche;
		this.datevalidation = datevalidation;
	}

	public Float getNotencadrant() {
		return notencadrant;
	}

	public void setNotencadrant(Float notencadrant) {
		this.notencadrant = notencadrant;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Enseignent getRapporteur() {
		return rapporteur;
	}
	public void setRapporteur(Enseignent rapporteur) {
		this.rapporteur = rapporteur;
	}
	public Float getNote() {
		return note;
	}
	public void setNote(Float note) {
		this.note = note;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FichePFE getFiche() {
		return fiche;
	}
	public void setFiche(FichePFE fiche) {
		this.fiche = fiche;
	}
	public Date getDatevalidation() {
		return datevalidation;
	}
	public void setDatevalidation(Date datevalidation) {
		this.datevalidation = datevalidation;
	}
	public ValidationTechnique(Long id, Enseignent rapporteur, Float note, String description, FichePFE fiche,
			Date datevalidation) {
		super();
		this.id = id;
		this.rapporteur = rapporteur;
		this.note = note;
		this.description = description;
		this.fiche = fiche;
		this.datevalidation = datevalidation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datevalidation == null) ? 0 : datevalidation.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fiche == null) ? 0 : fiche.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((rapporteur == null) ? 0 : rapporteur.hashCode());
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
		ValidationTechnique other = (ValidationTechnique) obj;
		if (datevalidation == null) {
			if (other.datevalidation != null)
				return false;
		} else if (!datevalidation.equals(other.datevalidation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fiche == null) {
			if (other.fiche != null)
				return false;
		} else if (!fiche.equals(other.fiche))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (rapporteur == null) {
			if (other.rapporteur != null)
				return false;
		} else if (!rapporteur.equals(other.rapporteur))
			return false;
		return true;
	}
	public ValidationTechnique() {
		super();
	}
	public ValidationTechnique(Long id, Float note, String description, FichePFE fiche) {
		super();
		this.id = id;
		this.note = note;
		this.description = description;
		this.fiche = fiche;
	}
	
	
	
}
