package com.techviz.app.pojos;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int id;
	@Column(name = "NAME", nullable = false)
	@NotBlank(message = "Name is required")
	@Size(min = 5, max = 30)
	private String name;
	@Column(name = "AGE")
	@Min(12)
	@NotNull(message = "Age is required.")
	private int age;
	@Column(name = "EMAIL", nullable = false)
	@NotBlank(message = "Email can't be blank.")
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	@Column(name = "MOBILE", nullable = false)
	@NotNull
	private long mobile;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(nullable = false)
	private List<Address> address;
	@Column(nullable = false)
	@NotBlank
	@Size(min = 4, max = 20)
	private String userName;
	@Column(name = "PASSWORD", nullable = false)
	@NotBlank(message = "Password is required.")
	@Size(min = 8, max = 24)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	private Role role;
	
	public User(int id, String name, int age, String email, long mobile, String userName, String password, Role role) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public void setUserName(String userId) {
		this.userName = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", mobile=" + mobile
				+ ", userId=" + userName + "]";
	}
}
