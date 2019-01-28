package com.slim.Domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Soutenance {
	
	private Integer idsoutenance;
	private Date datedebut;
	private Date datefinestimee;
	private String Description;
	private String dateSoutenance ;
	@ManyToOne
	 private Enseignent enseignent;
	//private Set<E> ensegnent = new HashSet<Enseignent>();
	 @ManyToOne
	 private Salle salle;
	@ManyToOne
	 private Session session;
	 
	 
	
	
	
	
	
	
	
	
	
	
	

	
	
	


	


	public Soutenance(Integer idsoutenance, Date datedebut, Date datefinestimee, String description,
			String dateSoutenance, Enseignent enseignent, Salle salle, Session session) {
		super();
		this.idsoutenance = idsoutenance;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		this.dateSoutenance = dateSoutenance;
		this.enseignent = enseignent;
		this.salle = salle;
		this.session = session;
	}


	public String getDateSoutenance() {
		return dateSoutenance;
	}


	public void setDateSoutenance(String dateSoutenance) {
		this.dateSoutenance = dateSoutenance;
	}


	public Soutenance(Integer idsoutenance, Date datedebut, Date datefinestimee, String description,
			Enseignent enseignent, Salle salle, Session session) {
		super();
		this.idsoutenance = idsoutenance;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		this.enseignent = enseignent;
		this.salle = salle;
		this.session = session;
	}


	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsession", nullable = false)
    @JsonBackReference
	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}


	public Soutenance(Integer idsoutenance, Date datedebut, Date datefinestimee, String description,
			Enseignent enseignent, Salle salle) {
		super();
		this.idsoutenance = idsoutenance;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		this.enseignent = enseignent;
		this.salle = salle;
	}


	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "idsalle", nullable = false)
	    @JsonBackReference
	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public Soutenance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "idUser", nullable = false)
	    @JsonBackReference
	public Enseignent getEnseignent() {
		return enseignent;
	}

	public void setEnseignent(Enseignent enseignent) {
		this.enseignent = enseignent;
	}

	public Soutenance(Integer idsoutenance, Date datedebut, Date datefinestimee, String description,
			Enseignent enseignent) {
		super();
		this.idsoutenance = idsoutenance;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
		this.enseignent = enseignent;
	}
	public Soutenance(Integer idsoutenance, Date datedebut, Date datefinestimee, String description) {
		super();
		this.idsoutenance = idsoutenance;
		this.datedebut = datedebut;
		this.datefinestimee = datefinestimee;
		Description = description;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idsoutenance", unique = true, nullable = false)
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

}
