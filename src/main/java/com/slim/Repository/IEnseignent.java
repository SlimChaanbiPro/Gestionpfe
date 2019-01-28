package com.slim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Departements;
import com.slim.Domain.Enseignent;





public interface IEnseignent extends JpaRepository<Enseignent,Integer> {
	List<Enseignent> findByDepartement(Departements d );
}
