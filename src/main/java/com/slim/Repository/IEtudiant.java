package com.slim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Etudiant;

//import esprit.tn.persistence.model.Entreprise;
public interface IEtudiant extends JpaRepository <Etudiant,Integer> {

}
