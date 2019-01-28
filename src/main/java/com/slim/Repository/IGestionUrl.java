package com.slim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slim.Domain.GestionUrl;



public interface IGestionUrl extends JpaRepository<GestionUrl, Long> {
	public GestionUrl  findByGestion(String gestion );
	

}
