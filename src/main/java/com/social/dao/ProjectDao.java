package com.social.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Experience;
import com.social.entities.Project;
import com.social.entities.Skills;

@Repository
public interface ProjectDao extends CrudRepository<Project, Long> {
	/*Collaborater save(Collaborater user);

	Collaborater findByUserName(String username);*/
	public Project findByIdProject(Long idProject);
	public Project findByName(String name);
}
