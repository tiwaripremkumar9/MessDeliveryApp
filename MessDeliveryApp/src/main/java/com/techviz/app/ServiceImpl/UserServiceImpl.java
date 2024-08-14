package com.techviz.app.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techviz.app.dto.UserDTO;
import com.techviz.app.pojos.Address;
import com.techviz.app.pojos.User;
import com.techviz.app.repository.UserRepository;
import com.techviz.app.service.IUserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public UserDTO createUser(User user) {
		List<Address> addrList = user.getAddress();
		for(Address each: addrList) {
			each.setUser(user);
		}
		User aNewUser = userRepo.save(user);
		UserDTO newUserDTO = this.convertToDTO(aNewUser);
		return newUserDTO;
		
	}
	
	public UserDTO convertToDTO(User aUser) {
		UserDTO userDTO = new UserDTO();
		userDTO = modelMapper.map(aUser, UserDTO.class);
		
		return userDTO;
	}
	

}
