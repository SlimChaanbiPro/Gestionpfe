package com.slim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Session;
import com.slim.Domain.Soutenance;

//import esprit.tn.persistence.model.Roles;


public interface ISoutenance extends JpaRepository<Soutenance,Integer> {
List<Soutenance> findBySession(Session s );
}
