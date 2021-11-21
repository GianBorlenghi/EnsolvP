package com.ensolvers.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ensolvers.app.entity.Task;

public interface ITask extends JpaRepository<Task, Long> {

}
