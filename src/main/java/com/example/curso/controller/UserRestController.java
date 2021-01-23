package com.example.curso.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entity.User;
import com.example.curso.model.JwtUser;
import com.example.curso.security.JwtGenerator;
import com.example.curso.service.IUserService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.POST})
@RequestMapping("/auth")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping(value= "/user")
	public ResponseEntity<?> addUser(@RequestBody User user){
		System.out.println("Validando usuario");
		if(userService.findUser(user) == null) {
			System.out.println("Creando usuario");
			userService.save(user);
			System.out.println("Usuario creado");
			User userDb = userService.checkUserLogin(user);
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(userDb.getId());
			jwtUser.setUserName(userDb.getEmail());
			System.out.println("Retornando token");
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping(value= "/auth")
	public ResponseEntity<?> loginUser(@RequestBody User user){
		User userDb = userService.checkUserLogin(user);
		if(userDb != null) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(userDb.getId());
			jwtUser.setUserName(userDb.getEmail());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	} 

}
