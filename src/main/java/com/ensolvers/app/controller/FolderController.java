package com.ensolvers.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.app.entity.Folder;
import com.ensolvers.app.entity.Task;
import com.ensolvers.app.service.IFolderService;
import com.ensolvers.app.service.ITaskService;


@RestController
@RequestMapping(value = "folder")
@CrossOrigin(origins = "http://localhost:4200") 
public class FolderController {

	
	@Autowired
	private IFolderService foldRep;

	
	//get all folders
	@GetMapping("/foldersList")
	public  List<Folder> listFolder(){
		List<Folder> folderList = foldRep.listFolder();
		return folderList;
		}
	//add folder
	
	@PostMapping("/saveFolder")
	public void addFolder(@RequestBody Folder folder) {
		foldRep.save(folder);

	}
	
	@GetMapping("/viewFolder/{id}")
	public List<Task> viewFolder(@PathVariable(value = "id") long idFolder) {
		Folder fol= foldRep.listIdFolder(idFolder);
		return fol.getTasksFold();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Folder> deleteFolder (@PathVariable(value = "id") long idFolder) {
		Folder folder = foldRep.listIdFolder(idFolder);
		if(folder != null) {
			foldRep.delete(folder);
			return new ResponseEntity<Folder> (folder, HttpStatus.OK);
		}else {
			return new ResponseEntity<Folder> (folder, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/update/{id}")
	public ResponseEntity<Folder> updateFolder (@PathVariable(value="id") long idFolder){
		Folder folder = foldRep.listIdFolder(idFolder);
		if(folder!=null) {
			String name = folder.getFolderName();
			folder.setFolderName(name);
			foldRep.save(folder);
			return new ResponseEntity<Folder> (folder, HttpStatus.OK);
		}else {
			return new ResponseEntity<Folder> (folder, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}