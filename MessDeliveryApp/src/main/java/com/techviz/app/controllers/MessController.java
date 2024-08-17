package com.techviz.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techviz.app.service.IMessService;

@RequestMapping("/api/mess")
@RestController
public class MessController {
	
	@Autowired
	private IMessService messService;
	
	@DeleteMapping("/{messId}")
	public ResponseEntity<String> deleteMess(@PathVariable int messId){
		String resp = messService.deleteMess(messId);
		return ResponseEntity.ok().body(resp);
	}

}
