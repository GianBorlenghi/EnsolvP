package com.ensolvers.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ensolvers.app.entity.Folder;
import com.ensolvers.app.entity.Task;
import com.ensolvers.app.repository.IFolder;
import com.ensolvers.app.repository.ITask;
import com.ensolvers.app.service.IFolderService;
import com.ensolvers.app.service.ITaskService;

	@RestController
	@RequestMapping(value = "task")
	@CrossOrigin(origins = "http://localhost:4200") 
	public class TaskController {

	@Autowired
	private ITaskService taskRep;
	
	//Get all tasks.
	@GetMapping("/listTask")
	@ResponseBody
	public  List<Task> findTasks(){
		List<Task> listTask = taskRep.listTasks();
		return listTask;
		}
	
	//Save a task
	@PostMapping("/saveTask")
	public void saveTask(@RequestBody Task task) {
		taskRep.save(task);
		
	}
	
	//Delete a task
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Task> deleteTask (@PathVariable(value = "id") long idTask) {
		Task task = taskRep.listarId(idTask);
		if(task != null) {
			taskRep.delete(task);
			return new ResponseEntity<Task> (task, HttpStatus.OK);
		}else {
			return new ResponseEntity<Task> (task, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//Update task.
	@GetMapping("/update/{id}")
	public ResponseEntity<Task> updateTask (@PathVariable(value="id") long idTask){
		Task task = taskRep.listarId(idTask);
		if(task!=null) {
			String name = task.getName();
			task.setName(name);
			taskRep.save(task);
			return new ResponseEntity<Task> (task, HttpStatus.OK);
		}else {
			return new ResponseEntity<Task> (task, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	}