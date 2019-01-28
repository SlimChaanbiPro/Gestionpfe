package com.slim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Departements;


//import esprit.tn.persistence.model.Enseignent;

public interface IDepartement extends JpaRepository<Departements,Integer> {
	public Departements findByLibelle(String libelle);

}
