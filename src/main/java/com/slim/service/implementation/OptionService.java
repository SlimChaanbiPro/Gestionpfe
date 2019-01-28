 package com.slim.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Optionnal;
import com.slim.Repository.IOption;




@Service
@Transactional
public class OptionService {
	@Autowired
    private IOption dao;

    public OptionService() {
    	//  super();
    }

    // API

    public void create(final Optionnal entity) {
    	System.out.println("dao "+dao);
    	System.out.println(entity);
        dao.save(entity);
    }
    
    

    public void update(final Optionnal entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(final Optionnal entity) {
        
    	System.out.println(entity);
        dao.delete(entity);
    }
    public List<Optionnal> findAll() {
    	System.out.println("dao "+dao);
    	 List<Optionnal> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Optionnal findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Optionnal e=	dao.getOne(id);
		return e;
	}
    
  


}

