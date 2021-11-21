package com.ensolvers.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ensolvers.app.entity.Task;

@Repository
public interface ITaskService {
	
	public List<Task> listTasks();
	public Task listarId(long id);
	public void save (Task task);
	public void delete(Task task);
} 
