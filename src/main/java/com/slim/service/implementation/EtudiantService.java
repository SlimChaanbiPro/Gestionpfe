package com.slim.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.Domain.Etudiant;
import com.slim.Repository.IEtudiant;




@Service
@Transactional
public class EtudiantService {
	
	@Autowired
    private IEtudiant dao;

    public EtudiantService() {
    	//  super();
    }

    // API

    public void create(final Etudiant entity) {
    	System.out.println("dao "+dao);
    	System.out.println(entity);
        dao.save(entity);
    }
    
    

    public void update(final Etudiant entity) {
        
    	System.out.println(entity);
        dao.save(entity);
    }
 public void delete(final Etudiant entity) {
        
    	System.out.println(entity);
        dao.delete(entity);
    }
    public List<Etudiant> findAll() {
    	System.out.println("dao "+dao);
    	 List<Etudiant> l= dao.findAll();
    		System.out.println("count "+l.size());
     return  l;
    }

	public Etudiant findbyid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id "+id);
		Etudiant e=	dao.getOne(id);
		return e;
	}
    
  


}
