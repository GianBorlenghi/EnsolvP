package com.ensolvers.app.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensolvers.app.entity.Folder;


@Repository
public interface IFolderService {
	
	public List<Folder> listFolder();
	public Folder listIdFolder(long id);
	public void save (Folder folder);
	public void delete(Folder folder);
}