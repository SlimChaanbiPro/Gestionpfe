package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Entreprise;
import com.slim.Repository.IEntreprise;


@Service
@Transactional
public class EntrepriseService {
	@Autowired
    private IEntreprise dao;

    public EntrepriseService() {
    	//  super();
    }

    // API

    public void create(final Entreprise entity) {
    	System.out.println("dao "+dao);
    	System.out.println(entity);
        dao.save(entity);
    }
    
    

    public void update(final Entreprise entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(final Entreprise entity) {
        
    	System.out.println(entity);
        dao.delete(entity);
    }
    public List<Entreprise> findAll() {
    	System.out.println("dao "+dao);
    	 List<Entreprise> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Entreprise findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Entreprise e=	dao.getOne(id);
		return e;
	}
    
  

}
