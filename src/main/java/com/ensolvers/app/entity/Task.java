package com.ensolvers.app.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTask;
	
	@Basic
	public String name;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "fk_folder")
	@JsonBackReference	
	private Folder taskFolder;

	public Task() {
		super();
	}

	public Task(long idTask, String name, Folder taskFolder) {
		super();
		this.idTask = idTask;
		this.name = name;
		this.taskFolder = taskFolder;
	}

	public long getIdTask() {
		return idTask;
	}

	public void setIdTask(long idTask) {
		this.idTask = idTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Folder gettaskFolder() {
		return taskFolder;
	}

	public void settaskFolder(Folder taskFolder) {
		this.taskFolder = taskFolder;
	}



	
	
}
