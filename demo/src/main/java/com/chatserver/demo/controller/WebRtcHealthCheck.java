package com.chatserver.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class WebRtcHealthCheck {

   /* @GetMapping
	public ResponseEntity<String> getMethodName() {
		return new ResponseEntity<>("success",HttpStatus.OK);
	} */

	@GetMapping
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("Healthy");
	}
}
