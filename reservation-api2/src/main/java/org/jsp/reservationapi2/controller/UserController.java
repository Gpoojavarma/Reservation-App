package org.jsp.reservationapi2.controller;

import org.jsp.reservationapi2.dto.ResponseStructure;

import org.jsp.reservationapi2.model.User;

import org.jsp.reservationapi2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveuser(user);
	}
}




	

