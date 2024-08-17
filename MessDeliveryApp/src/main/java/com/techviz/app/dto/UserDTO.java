package com.techviz.app.dto;


import com.techviz.app.pojos.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int id;
	private String name;
	private int age;
	private String email;
	private long mobile;
	private String userName;
	private Role role;

}
