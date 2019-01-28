/**
 * 
 */
package com.slim.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slim.Domain.AccessUrl;
import com.slim.Domain.Authority;
import com.slim.Domain.GestionUrl;
import com.slim.Repository.IAccessUrl;
import com.slim.Repository.IAuthority;
import com.slim.Repository.IGestionUrl;

/**
 * @author slim
 *
 */
@Service
public class AccessUrlService {
	@Autowired
	IAccessUrl iAccessUrl;
	@Autowired
	IGestionUrl iGestionUrl;
	@Autowired
	IAuthority iAuthority;
	
	public AccessUrl getAccessByGestionAndRole(String gestion,String role){
		System.out.println("gestion a lentree"+gestion);
		System.out.println("role a lentree"+role);
		GestionUrl gestionurl = new GestionUrl();
		Authority authority = new Authority();
		
		
		gestionurl=this.iGestionUrl.findByGestion(gestion);
		System.out.println("Gestion des roles"+gestionurl);
		authority =this.iAuthority.findByDescription(role);
		System.out.println("role"+authority);
		return this.iAccessUrl.findByauthorityAndGestionUrl(authority, gestionurl);
		
		
		
		
	}

}
