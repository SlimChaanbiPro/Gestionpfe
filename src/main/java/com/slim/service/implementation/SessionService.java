package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Session;
import com.slim.Repository.ISession;



@Service
@Transactional
public class SessionService {
	
	
	@Autowired
    private ISession dao;

    public SessionService() {
    	//  super();
    }

    // API

    public void create(final Session entity) {
    	System.out.println("dao "+dao);
    	System.out.println(entity);
        dao.save(entity);
    }
    
    

    public void update(final Session entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(final Session entity) {
        
    	System.out.println(entity);
        dao.delete(entity);
    }
    public List<Session> findAll() {
    	System.out.println("dao "+dao);
    	 List<Session> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Session findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Session e=	dao.getOne(id);
		return e;
	}
    
  

}
