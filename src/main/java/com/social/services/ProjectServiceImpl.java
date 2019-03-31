package com.social.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.social.dao.ExperienceDao;
import com.social.dao.ProjectDao;
import com.social.dao.SkillsDao;
import com.social.entities.Experience;
import com.social.entities.Project;
import com.social.entities.Skills;
import com.social.entities.User;


@CrossOrigin("*")
@Service
public class ProjectServiceImpl {

	@Autowired
	private ProjectDao projectDao;

	public Project save(Project project) {
		return projectDao.save(project);
	}
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return (List<Project>) projectDao.findAll();
	}
	public Project findProjectByName(String name) {
		return projectDao.findByName(name);
	}
	public Project getProjectById(Long idProject) {
		// TODO Auto-generated method stub
		return projectDao.findOne(idProject);
	}
	
	public void deleteExperience(Long idProject) {
		projectDao.delete(idProject);
	}

	@Transactional
	public void updateProject(Long idProject, Project project){
		Project projectManagedEntity = projectDao.findOne(idProject);
		if(projectManagedEntity == null){
			throw new NoResultException();
		}
		projectManagedEntity.setCity(project.getCity());
		projectManagedEntity.setStartDate(project.getStartDate());
		projectManagedEntity.setDescription(project.getDescription());
		projectManagedEntity.setDureeProject(project.getDureeProject());
		projectManagedEntity.setName(project.getName());
		// Il faut faire attention lorsqu'on utilise save pour mettre a jour un enregistrement dans
		// la base de données.
		// Dans ce cas si on utilise save, tout l'objet va etre sauvegardé dans la base,
		// y compris la valeur null de "client_id".
		//project.setId(projectId);
		//projectRepository.save(project);
	}
	
	

}
