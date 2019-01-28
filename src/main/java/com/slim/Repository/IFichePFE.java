package com.slim.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.slim.Domain.FichePFE;



public interface IFichePFE extends JpaRepository<FichePFE, Integer> {
	@Query("select f from FichePFE f where f.titre like :x")
	public Page<FichePFE>chercher(@Param("x") String mc, Pageable pageable);

}
