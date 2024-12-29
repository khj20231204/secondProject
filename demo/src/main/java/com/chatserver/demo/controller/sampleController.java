package com.chatserver.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class sampleController {

	@GetMapping("/")
	public ResponseEntity<String> sample() {
		
		System.out.println("connect successful");

		return ResponseEntity.ok("main connect successful");
	}	

	
	
}
