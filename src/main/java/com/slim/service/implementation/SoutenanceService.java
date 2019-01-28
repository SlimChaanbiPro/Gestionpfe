package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Soutenance;
import com.slim.Repository.ISoutenance;



@Service
@Transactional
public class SoutenanceService {

	@Autowired
    private ISoutenance dao;

    public SoutenanceService() {
    	//  super();
    }

    // API

    public void create(final Soutenance entity) {
    	System.out.println("dao "+dao);
    	System.out.println(entity);
        dao.save(entity);
    }
    
    

    public void update(final Soutenance entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(final Soutenance entity) {
        
    	System.out.println(entity);
        dao.delete(entity);
    }
    public List<Soutenance> findAll() {
    	System.out.println("dao "+dao);
    	 List<Soutenance> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Soutenance findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Soutenance e=	dao.getOne(id);
		return e;
	}


}
