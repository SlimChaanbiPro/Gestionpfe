package com.slim.Controller;



import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slim.Config.WebSecurityConfig;
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

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/gestionUrl")
public class GestionUrlController {

	@Autowired
	IGestionUrl iGestionUrl;

	@Autowired
	IAccessUrl iAccessUrl;

	@Autowired
	IAuthority iAuthority;
	
	@Autowired
	WebSecurityConfig websec;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> addGroupe(Model model, @RequestBody GestionUrl gestionUrl) {
		try {
			iGestionUrl.save(gestionUrl);
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;

		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}

	@RequestMapping(value = "/setaccess", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> addaccess() {
		try {
			AccessUrl accessUrl;
			List<Authority> authorities = iAuthority.findAll();

			for (Authority authority : authorities) {

				List<GestionUrl> gestionUrls = iGestionUrl.findAll();
				for (GestionUrl url : gestionUrls) {
					accessUrl = new AccessUrl();
					// accessUrl.setId(null);
					accessUrl.setAuthority(authority);
					accessUrl.setGestionUrl(url);
					if (authority.getName().equals("ROLE_Admin")) {
						accessUrl.setAddop(true);
						accessUrl.setGetallop(true);
						accessUrl.setGetbyidop(true);
						accessUrl.setRemoveop(true);
						accessUrl.setUpdateop(true);
					} else {
						accessUrl.setAddop(false);
						accessUrl.setGetallop(false);
						accessUrl.setGetbyidop(false);
						accessUrl.setRemoveop(false);
						accessUrl.setUpdateop(false);
					}
					iAccessUrl.save(accessUrl);
				}
			}
			
			
			
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;

		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}

}
