package com.slim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Salle;
import com.slim.Domain.Utilisateur;

public interface SalleRepository extends JpaRepository<Salle,Long> {
	
	
	Salle findByNomSalle( String nomSalle );
}
