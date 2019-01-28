package com.slim.Dto;





import lombok.Data;


public class SalleDTO {
	private String nomSalle;
	private String type ;
	private String remarque ;
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public SalleDTO() {
		super();
	}
	public SalleDTO(String nomSalle, String type, String remarque) {
		super();
		this.nomSalle = nomSalle;
		this.type = type;
		this.remarque = remarque;
	}

}
