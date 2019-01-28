package com.slim.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.slim.Domain.AccessUrl;
import com.slim.Domain.Authority;
import com.slim.Domain.GestionUrl;



public interface IAccessUrl extends JpaRepository<AccessUrl, Long> {

	@Query("SELECT p FROM AccessUrl p WHERE p.authority = :authority ")
    public List<AccessUrl> findbyauthority(@Param("authority") Authority authority);
	public AccessUrl findByauthorityAndGestionUrl(Authority role , GestionUrl gestion);
}
