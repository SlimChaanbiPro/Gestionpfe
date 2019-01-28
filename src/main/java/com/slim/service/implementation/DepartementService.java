package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Departements;
import com.slim.Repository.IDepartement;


@Service
@Transactional
public class DepartementService {
	@Autowired
    private IDepartement dao;

    public DepartementService() {
    	//  super();
    }

    // API

    public void create( Departements entity) {
    	System.out.println("dao "+entity.getLibelle());
    	System.out.println(entity);
        this.dao.save(entity);
    }
    
    

    public void update(final Departements entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(Integer id ) {
        
    	System.out.println("haw zabourom lid"+id);
    	this.dao.delete(id);
       
    }
    public List<Departements> findAll() {
    	System.out.println("dao "+dao);
    	 List<Departements> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Departements findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Departements e=	dao.getOne(id);
		return e;
	}
    
  


}
