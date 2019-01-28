/**
 * 
 */
package com.slim.Dto;

import java.util.Date;
import java.util.List;

import com.slim.Domain.Enseignent;
import com.slim.Domain.FichePFE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author slim
 *
 */

public class ValidationTechniqueDTO {
	private Enseignent rapporteur ;
	private Float note ;
	private String description ; 
	private FichePFE fiche ;
	private Date datevalidation;
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
	public ValidationTechniqueDTO(Enseignent rapporteur, Float note, String description, FichePFE fiche,
			Date datevalidation) {
		super();
		this.rapporteur = rapporteur;
		this.note = note;
		this.description = description;
		this.fiche = fiche;
		this.datevalidation = datevalidation;
	}
	public ValidationTechniqueDTO() {
		super();
	}
	
	

}
