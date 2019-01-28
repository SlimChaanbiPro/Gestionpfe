package com.slim.Dto;



import java.util.Date;

import lombok.Data;


public class SessionDTO {
	private String description;
	private Date datedebut;
	private Date datefinestimee;
	
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
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public SessionDTO(Date datedebut, Date datefinestimee, String description) {
		super();
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		description = description;
	}
	public SessionDTO() {
		super();
	}
	
	
	
}
