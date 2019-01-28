package com.slim.Domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author slim
 *
 */
@Entity

public class Salle  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsalle ;
	private String nomSalle;
	private String Type ;
	private String remarque ;
	


	
	public Salle(Long idsalle, String nomSalle) {
		super();
		this.idsalle = idsalle;
		this.nomSalle = nomSalle;
	}




	public Salle(String nomSalle) {
		super();
		this.nomSalle = nomSalle;
	}




	public Salle(Long idsalle, String nomSalle, String type, String remarque) {
		super();
		this.idsalle = idsalle;
		this.nomSalle = nomSalle;
		Type = type;
		this.remarque = remarque;
	}




	public Salle() {
		super();
	}




	public Long getIdsalle() {
		return idsalle;
	}




	public void setIdsalle(Long idsalle) {
		this.idsalle = idsalle;
	}




	public String getNomSalle() {
		return nomSalle;
	}




	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}




	public String getType() {
		return Type;
	}




	public void setType(String type) {
		Type = type;
	}




	public String getRemarque() {
		return remarque;
	}




	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}




	public Salle(String nomSalle, String type, String remarque) {
		super();
		this.nomSalle = nomSalle;
		Type = type;
		this.remarque = remarque;
	}
	
	
	

}
