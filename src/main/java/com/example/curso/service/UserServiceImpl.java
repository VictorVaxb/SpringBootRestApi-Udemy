package com.example.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.dao.IUserDao;
import com.example.curso.entity.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User checkUserLogin(User user) {
		return (User) userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userDao.findByIdSQL(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(User user) {
		return userDao.findByEmail(user.getEmail());
	}

}
