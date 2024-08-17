package com.techviz.app.service;

import org.springframework.stereotype.Service;

import com.techviz.app.dto.UserDTO;
import com.techviz.app.pojos.User;
@Service
public interface IUserService {
	
	UserDTO createUser(User user);

}
