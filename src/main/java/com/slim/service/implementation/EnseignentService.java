package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Enseignent;
import com.slim.Repository.IEnseignent;


@Service
@Transactional
public class EnseignentService {
	@Autowired
    private IEnseignent dao;

	
	
    public EnseignentService() {
    	//  super();
    }

    // API

    public void create(final Enseignent entity) {
    	System.out.println("dao "+dao);
    	System.out.println(entity);
        dao.save(entity);
    }
    
    

    public void update(final Enseignent entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(final Enseignent entity) {
        
    	System.out.println(entity);
        dao.delete(entity);
    }
    public List<Enseignent> findAll() {
    	System.out.println("dao "+dao);
    	 List<Enseignent> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Enseignent findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Enseignent e=	dao.getOne(id);
		return e;
	}
    
  



}
