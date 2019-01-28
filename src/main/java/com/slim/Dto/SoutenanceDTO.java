package com.slim.Dto;

import java.util.Date;

public class SoutenanceDTO {
	private Integer idsoutenance;
	private Date datedebut;
	private Date datefinestimee;
	private String Description;
	private String dateSoutenance ;
	private String dateSoutenanceEnd ;
	private String dateSoutenancebegin ;
	
	public Long getIdsalle() {
		return idsalle;
	}
	public void setIdsalle(Long idsalle) {
		this.idsalle = idsalle;
	}
	public SoutenanceDTO(Integer idsoutenance, Date datedebut, Date datefinestimee, String description,
			String dateSoutenanceEnd, String dateSoutenancebegin, Integer id_user, Long idsalle, Integer idsession) {
		super();
		this.idsoutenance = idsoutenance;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		this.dateSoutenanceEnd = dateSoutenanceEnd;
		this.dateSoutenancebegin = dateSoutenancebegin;
		this.id_user = id_user;
		this.idsalle = idsalle;
		this.idsession = idsession;
	}
	public SoutenanceDTO() {
		super();
	}
	public String getDateSoutenancebegin() {
		return dateSoutenancebegin;
	}
	public void setDateSoutenancebegin(String dateSoutenancebegin) {
		this.dateSoutenancebegin = dateSoutenancebegin;
	}
	public String getDateSoutenanceEnd() {
		return dateSoutenanceEnd;
	}
	public void setDateSoutenanceEnd(String dateSoutenanceEnd) {
		this.dateSoutenanceEnd = dateSoutenanceEnd;
	}
	private Integer id_user ;
	private Long idsalle ;
	private Integer idsession ;
	public Integer getIdsoutenance() {
		return idsoutenance;
	}
	public void setIdsoutenance(Integer idsoutenance) {
		this.idsoutenance = idsoutenance;
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
	public String getDateSoutenance() {
		return dateSoutenance;
	}
	public void setDateSoutenance(String dateSoutenance) {
		this.dateSoutenance = dateSoutenance;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getIdsession() {
		return idsession;
	}
	public void setIdsession(Integer idsession) {
		this.idsession = idsession;
	}
	
}
