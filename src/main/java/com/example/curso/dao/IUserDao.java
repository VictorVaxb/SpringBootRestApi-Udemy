package com.example.curso.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.curso.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String password);
	
	@Query("select u from User u where u.id=?1")
	public User findByIdSQL(Long id);

}
