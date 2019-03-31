package com.social.controller;


import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.social.dao.ProjectDao;


import com.social.entities.Project;

import com.social.services.ProjectServiceImpl;
import com.social.util.CustomErrorType;






@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/projects")
public class ProjectController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private ProjectDao projectDao;
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody Project newProject) {
		if (projectService.findProjectByName(newProject.getName()) != null) {
			logger.error("name Already exist " + newProject.getName());
			return new ResponseEntity(
					new CustomErrorType("project with name " + newProject.getName() + "already exist "),
					HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Project>(projectService.save(newProject), HttpStatus.CREATED);
	}
	@RequestMapping(value = "/projects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getAllProjects(){
    	logger.debug("Invocation de la resource : GET /projects");
    	List<Project> projects = projectService.getAllProjects();
    	if(projects.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @RequestMapping(value = "/projects/{idProject}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProjectById(@PathVariable("idProject") Long idProject) {
    	logger.debug("Invocation de la resource : GET /projects/{idProject}");
    	
    	Project project = projectService.getProjectById(idProject);
    	if(project == null){
    		logger.info("Impossible de trouver le project");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/projects/{idProject}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProject(@PathVariable("idProject") Long idProject){
    	logger.debug("Invocation de la resource : DELETE /projects/");
    	projectDao.delete(idProject);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    /*
   @PutMapping(value = "/projects/{idProject}")
    public ResponseEntity<Void> updateProject(@RequestBody Project project, 
    											@PathVariable("idProject") Long idProject){
    	logger.debug("Invocation de la resource : PUT /projects/{idProject}");
    	try{
    		projectService.updateProject(idProject, project);
    	}catch (NoResultException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	return new ResponseEntity<>(HttpStatus.OK);
    }*/
	@RequestMapping(value="/projects",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> updateProject(@RequestBody Project project) {
		return new ResponseEntity<Project>(projectDao.save(project), HttpStatus.ACCEPTED);

		//return projectDao.save(project);
	}

  /*@PutMapping("/projects")
    public Project UpdateProject(Project project) {
		Project projectManagedEntity = projectDao.findOne(project.getIdProject());
		if(projectManagedEntity == null){
			throw new NoResultException();
		}
		else {
		project.setIdProject(projectManagedEntity.getIdProject());
	  	project.getIdProject();
    	return projectDao.save(project);
		}
    }
	*/
}
