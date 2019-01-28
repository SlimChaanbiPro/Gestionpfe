package com.slim.Domain;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEtud; 
	private String nom;
	private String prenom;
	private String mail;
	private String pwd;
	private String tel;
	


	@ManyToOne
	private Optionnal option;
	
	 @ManyToOne
	
	 @JsonIgnore
	private Session sessions ;
	
	
	
	
	
	




	public Optionnal getOption() {
		return option;
	}


	public void setOption(Optionnal option) {
		this.option = option;
	}


	


	
	@JsonIgnore
	public Session getSessions() {
		return sessions;
	}


	public void setSessions(Session sessions) {
		this.sessions = sessions;
	}


	public String getTel() {
		return tel;
	}
	
	public Etudiant(Integer idEtud, String nom, String prenom, String mail, String pwd, String tel) {
		super();
		this.idEtud = idEtud;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
		this.tel = tel;
	}

	
	


	


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	public Set<Option> getOptions() {
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options = options;
	}*/
	/*@ManyToMany(fetch = FetchType.EAGER)
	public Set<Option> getOption() {
		return option;
	}
	public void setOption(Set<Option> option) {
		this.option = option;
	}*/
	
	
	
	public Integer getIdEtud() {
		return idEtud;
	}
	public void setIdEtud(Integer idEtud) {
		this.idEtud = idEtud;
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
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
