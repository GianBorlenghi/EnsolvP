package com.ensolvers.app.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

	@Entity
	@Table(name = "folders")
	public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFolder;

	@Basic
	private String folderName;

	@OneToMany(mappedBy = "taskFolder", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Task> tasksFold;

	public Folder() {
		super();
	}

	public Folder(long idFolder, String folderName, List<Task> tasksFold) {
		super();
		this.idFolder = idFolder;
		this.folderName = folderName;
		this.tasksFold = tasksFold;
	}

	public long getIdFolder() {
		return idFolder;
	}

	public void setIdFolder(long idFolder) {
		this.idFolder = idFolder;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public List<Task> getTasksFold() {
		return tasksFold;
	}

	public void setTasksFold(List<Task> tasksFold) {
		this.tasksFold = tasksFold;
	}

}