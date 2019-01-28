package com.slim.Domain;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

 @Entity
 public class Optionnal {
	 
	 @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String type;
	private String Description;
	
	@OneToMany(mappedBy = "option")
	@JsonIgnore
	private List<Etudiant> etudiant ;
	
	
	
	
	
	public Optionnal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}


	@JsonIgnore
	public List<Etudiant> getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}


	public Optionnal(Integer id, String type, String description, List<Etudiant> etudiant) {
		super();
		Id = id;
		this.type = type;
		Description = description;
		this.etudiant = etudiant;
		// 86b77120
	}
	


}
