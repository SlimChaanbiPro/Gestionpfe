package com.slim.Domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Enseignent {
	private Integer idUser;
	//private Departements departements;
	//private Roles roles;
	private String nom;
	private String prenom;
	private String mail;
	private String pwd;
	private String tel;
	private String type;
	private String departementEnseignant;
	private List<Soutenance> Soutenance ;
  
	private List<ValidationTechnique> validations ;
	
	
	
	
	
	
	
    public Enseignent(Integer idUser, String nom, String prenom, String mail, String pwd, String tel, String type,
			String departementEnseignant, Departements departement) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
		this.tel = tel;
		this.type = type;
		this.departementEnseignant = departementEnseignant;
		this.departement = departement;
	}


	public String getDepartementEnseignant() {
		return departementEnseignant;
	}


	public void setDepartementEnseignant(String departementEnseignant) {
		this.departementEnseignant = departementEnseignant;
	}

	  @OneToMany(mappedBy = "rapporteur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    @JsonIgnore
	public List<ValidationTechnique> getValidations() {
		return validations;
	}


	public void setValidations(List<ValidationTechnique> validations) {
		this.validations = validations;
	}
	private Departements departement;
	

    @OneToMany(mappedBy = "enseignent",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
	public List<Soutenance> getSoutenance() {
		return Soutenance;
	}


	public void setSoutenance(List<Soutenance> soutenance) {
		Soutenance = soutenance;
	}


	


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	

	


	



	public Enseignent(Integer idUser, String nom, String prenom, String mail, String pwd, String tel, String type,
			List<Soutenance> soutenance, Departements departement) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
		this.tel = tel;
		this.type = type;
		Soutenance = soutenance;
		this.departement = departement;
	}

	
	 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddepartement", nullable = false)
	 @JsonIgnore
	public Departements getDepartement() {
		return departement;
	}


	public void setDepartement(Departements departement) {
		this.departement = departement;
	}


	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	public Set<Salle> getSalle() {
		return salle;
	}
	public void setSalle(Set<Salle> salle) {
		this.salle = salle;
	}*/
	public Enseignent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idenseignent", unique = true, nullable = false)
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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


	
	
	

}
