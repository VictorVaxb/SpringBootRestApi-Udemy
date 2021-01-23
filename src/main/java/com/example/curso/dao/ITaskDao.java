package com.example.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.curso.entity.Task;

public interface ITaskDao extends CrudRepository<Task, Long> {

	public List<Task> findByUserId(Long id);
	
	@Query("select t from Task t where t.id=?1")
	public Task findByIdSQL(Long id);
}
