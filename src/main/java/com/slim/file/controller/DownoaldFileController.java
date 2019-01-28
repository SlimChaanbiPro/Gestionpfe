package com.slim.file.controller;

import java.util.List;
import java.util.Optional;

//import org.apache.hadoop.mapred.gethistory_jsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.slim.file.model.FileModel;
import com.slim.file.model.View;
import com.slim.file.repository.FileRepository;

//import scala.annotation.meta.getter;
@CrossOrigin(origins = "*")
@RestController
public class DownoaldFileController {
	
	@Autowired
	FileRepository fileRepository;
 
	/*
	 * List All Files
	 */
    @JsonView(View.FileInfo.class)
	@GetMapping("/api/file/all")
	public List<FileModel> getListFiles() {
		return fileRepository.findAll();
	}
	
    /*
     * Download Files
     */
	@GetMapping("/api/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		FileModel fileOptional = fileRepository.findOne(id);
		
		if(fileOptional != null) {
			//Object file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileOptional.getName() + "\"")
					.body(fileOptional.getPic());
			//System.out.println("********ffff*****");
		}
		
		return ResponseEntity.status(404).body(null);
	}

}
