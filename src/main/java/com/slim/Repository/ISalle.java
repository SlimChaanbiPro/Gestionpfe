package com.slim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Salle;

//import esprit.tn.persistence.model.Roles;


public interface ISalle extends JpaRepository<Salle,Long> {

}
