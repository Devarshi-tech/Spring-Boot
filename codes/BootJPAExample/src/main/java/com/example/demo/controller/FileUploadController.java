package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadHelper fuh;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(
			@RequestParam("file") MultipartFile partfile){
		
//		partfile.getContentType() --> file type jpeg....
		try {
		if(partfile.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please attach image");
		}
		
//		if(!partfile.getContentType().equals("image/jpeg")) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please upload valid document format");
//
//		}
		// file upload code
//		UPLOAD_DIR = E:\codes\Spring-Boot\codes\BootJPAExample\src\main\resources\static\image
		
		boolean f = fuh.uploadFile(partfile);
		if(f) {
			System.out.println(fuh.UPLOAD_DIR);
			return ResponseEntity.ok(partfile.getOriginalFilename() 
					+ " Uloaded successfuly!" 
					+ "at " 
					+ fuh.UPLOAD_DIR);
//			context path here give localhost:8080 path
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong!!");


	}

}
