package com.techviz.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techviz.app.dto.MessDTO;
import com.techviz.app.dto.UserDTO;
import com.techviz.app.pojos.Mess;
import com.techviz.app.pojos.User;
import com.techviz.app.service.IMessService;
import com.techviz.app.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IMessService messService;
	
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> registerAUser(@Valid @RequestBody User user){
		UserDTO createdUser = userService.createUser(user);
		return ResponseEntity.accepted().body(createdUser);
		
	}
	
	@PostMapping(value = "/mess", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessDTO> registerMess(@Valid @RequestBody Mess mess){
		MessDTO registeredMess = messService.registerMess(mess);
		return ResponseEntity.accepted().body(registeredMess);
		
	}
//	
	

}
