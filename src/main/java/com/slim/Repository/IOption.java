package com.slim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Optionnal;

//import esprit.tn.persistence.model.Option;

//import esprit.tn.persistence.model.FichePFE;

public interface IOption extends JpaRepository<Optionnal, Integer>{

}
