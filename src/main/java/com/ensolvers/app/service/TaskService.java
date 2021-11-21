package com.ensolvers.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.app.entity.Task;
import com.ensolvers.app.repository.ITask;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private ITask taskRep;

	@Override
	public List<Task> listTasks() {
		return (List<Task>) taskRep.findAll();
	}

	@Override
	public Task listarId(long id) {
	Optional<Task> opt = taskRep.findById(id);
		Task task = null;
		if(opt.isPresent()) {
			task = opt.get();
		}else {
			throw new RuntimeException("nou");
		}
		return task;
	}

	@Override
	public void save(Task task) {
		taskRep.save(task);
	
	}

	@Override
	public void delete(Task task) {
		
		taskRep.delete(task);
	}



}
