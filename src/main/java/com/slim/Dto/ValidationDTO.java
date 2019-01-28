package com.slim.Dto;

public class ValidationDTO {
	Long id ;
	float noteencadrent;
	float noterapporteur;
	Integer idrapporteur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getNoteencadrent() {
		return noteencadrent;
	}
	public void setNoteencadrent(float noteencadrent) {
		this.noteencadrent = noteencadrent;
	}
	public float getNoterapporteur() {
		return noterapporteur;
	}
	public void setNoterapporteur(float noterapporteur) {
		this.noterapporteur = noterapporteur;
	}
	public Integer getIdrapporteur() {
		return idrapporteur;
	}
	public void setIdrapporteur(Integer idrapporteur) {
		this.idrapporteur = idrapporteur;
	}
	

}
