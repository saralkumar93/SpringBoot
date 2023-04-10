package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		try {
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only JPEG content type are allowed");
		}
		// file upload code...
		//C:\Users\Saral_Kumar\Desktop\60 days challenge full stack developer\springboot all in one\sb\SpringbootRestApi\src\main\resources\static\img
		boolean f = fileUploadHelper.UploadFile(file);
		if(f) {
			return ResponseEntity.ok("File is successfully uoloaded");
		}
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong please try again");
	}

}
