package com.example.curso.service;

import java.util.List;

import com.example.curso.entity.Task;

public interface ITaskService {

	public List<Task> findAll();
	
	public void saveTask(Task task);
	
	public List<Task> getTasksUser(Long id);
	
	public Task findByIdSQL(Long id);
	
	public void deleteTask(Long id);
}
