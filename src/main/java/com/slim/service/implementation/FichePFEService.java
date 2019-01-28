package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.FichePFE;
import com.slim.Repository.IFichePFE;




@Service
@Transactional
public class FichePFEService {
	 @Autowired
	    private IFichePFE dao;

	    public FichePFEService() {
	    	//  super();
	    }

	    // API

	    public void create(final FichePFE entity) {
	    	System.out.println("dao "+dao);
	    	System.out.println(entity);
	        dao.save(entity);
	    }
	    
	   

	    public void delete(final FichePFE entity) {
	        
	    	System.out.println(entity);
	        dao.delete(entity);
	    }
	    public void update(final FichePFE entity) {
	        
	    	System.out.println(entity);
	        dao.save(entity);
	    }
	    public List<FichePFE> findAll() {
	    	System.out.println("dao "+dao);
	    	 List<FichePFE> l= dao.findAll();
	    		System.out.println("count "+l.size());
	     return  l;
	    }
	    
	   

	    
		public FichePFE findbyid(Integer id) {
			// TODO Auto-generated method stub
			System.out.println("id "+id);
			FichePFE e=	dao.getOne(id);
			return e;
		}
	    


}
