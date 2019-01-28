package com.slim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Enseignent;
import com.slim.Domain.ValidationTechnique;

public interface IValidationTechnique  extends JpaRepository<ValidationTechnique, Long>{
public  List <ValidationTechnique> findByRapporteur(Enseignent enseignent);
}
