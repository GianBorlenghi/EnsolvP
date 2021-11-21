package com.ensolvers.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.app.entity.Folder;
import com.ensolvers.app.entity.Task;
import com.ensolvers.app.repository.IFolder;

@Service
public class FolderService implements IFolderService {

	@Autowired
	private IFolder folderRep;
	
	@Override
	public List<Folder> listFolder() {
	return (List<Folder>) folderRep.findAll();
	}

	@Override
	public Folder listIdFolder(long id) {
		Optional<Folder> opt = folderRep.findById(id);
		Folder folder = null;
		if(opt.isPresent()) {
			folder = opt.get();
		}else {
			throw new RuntimeException("nou");
		}
		return folder;
	}
		
	

	@Override
	public void save(Folder folder) {
		folderRep.save(folder);
		
	}

	@Override
	public void delete(Folder folder) {
		folderRep.delete(folder);
	}

}