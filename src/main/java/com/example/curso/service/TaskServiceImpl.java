package com.example.curso.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.dao.ITaskDao;
import com.example.curso.entity.Task;

@Service
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	private ITaskDao taskDao;

	@Override
	@Transactional(readOnly=true)
	public List<Task> findAll() {
		return (List<Task>) taskDao.findAll();
	}

	@Override
	@Transactional
	public void saveTask(Task task) {
		taskDao.save(task);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Task> getTasksUser(Long id) {
		return (List<Task>) taskDao.findByUserId(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Task findByIdSQL(Long id) {
		return taskDao.findByIdSQL(id);
	}

	@Override
	@Transactional
	public void deleteTask(Long id) {
		taskDao.deleteById(id);
		
	}

}
