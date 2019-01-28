package com.slim.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slim.Domain.FichePFE;
import com.slim.Repository.IFichePFE;
import com.slim.file.model.FileModel;
import com.slim.file.repository.FileRepository;


@CrossOrigin(origins = "*")
@RestController
public class UploadFileController {
	
	@Autowired
	FileRepository fileRepository;
	@Autowired
	IFichePFE ifichepfe;
    /*
     * MultipartFile Upload
     */
	 @PostMapping("/api/file/upload")
	    public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@RequestParam("id") Integer id) {
	    	try {
	    		FichePFE fiche = ifichepfe.findOne(id);
	    		
	    		// save file to PostgreSQL
		    	FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
		    	FileModel rapport =  this.fileRepository.save(filemode);
		    	fiche.setDepotrapport(true);
		    	fiche.setRapport(rapport);
		    	ifichepfe.save(fiche);
		    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
			} catch (	Exception e) {
				return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
			}    
	    }
	 
	 //
	 
	 @PostMapping("/api/file/delete")
	    public String deleteMultipartFile(@RequestParam("file") MultipartFile file) {
	    	try {
	    		// save file to PostgreSQL
		    	FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
		    	
		    	filemode.setName(file.getOriginalFilename());
		    	fileRepository.delete(filemode);
		    	//fileRepository.save(filemode);
		    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
			} catch (	Exception e) {
				return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
			}    
	    }
	 
}
