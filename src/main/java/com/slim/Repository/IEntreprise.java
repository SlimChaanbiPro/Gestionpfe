package com.slim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Entreprise;



public interface IEntreprise extends JpaRepository <Entreprise,Integer> {
Entreprise findByNom(String nom);
}
