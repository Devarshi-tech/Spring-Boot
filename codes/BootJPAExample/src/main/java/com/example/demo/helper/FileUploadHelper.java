package com.example.demo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	Static path
//	public final String UPLOAD_DIR = "E:\\codes\\Spring-Boot\\codes\\BootJPAExample\\src\\main\\resources\\static\\image";
	
//	Dynamic path
//	ClassPathResource will give the path upto target/classes -> this folder is generated after build/run
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	// default constructor
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile mpf) {
		
		boolean f = false;
//		try {
//			InputStream is = mpf.getInputStream();
//			
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
////			write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ "\\" +mpf.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			f = true;
//		}
		
		// same as above
		try {
//			String contentType = mpf.getContentType();
			String fileType;
			fileType = mpf.getContentType().equals("image/jpeg") ? ".jpeg" : ".bak";
			
//			Files.copy(mpf.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+ "devarshi"+ fileType),StandardCopyOption.REPLACE_EXISTING);
//			Files.delete(Paths.get("E:\\codes\\Spring-Boot\\codes\\BootJPAExample\\target\\classes\\static\\image\\devarshi.jpeg"));
			f = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
}
