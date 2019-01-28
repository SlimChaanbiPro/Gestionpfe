package com.slim.Dto;

public class EnseignantDTO {
	private String nom;
	private String prenom;
	private String mail;
	private String pwd;
	private String tel;
	private String type;
	private String departementEnseignant;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepartementEnseignant() {
		return departementEnseignant;
	}
	public void setDepartementEnseignant(String departementEnseignant) {
		this.departementEnseignant = departementEnseignant;
	}
	public EnseignantDTO(String nom, String prenom, String mail, String pwd, String tel, String type,
			String departementEnseignant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
		this.tel = tel;
		this.type = type;
		this.departementEnseignant = departementEnseignant;
	}
	

}
