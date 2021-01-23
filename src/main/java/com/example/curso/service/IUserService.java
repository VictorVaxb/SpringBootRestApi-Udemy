package com.example.curso.service;

import com.example.curso.entity.User;

public interface IUserService {
	
	public void save(User user);
	
	public User checkUserLogin(User user);
	
	public User findById(Long id);
	
	public User findUser(User user);
	
}
