package com.social.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ExperienceDao;
import com.social.dao.SkillsDao;
import com.social.entities.Experience;
import com.social.entities.Project;
import com.social.entities.Skills;
import com.social.services.ExperienceServiceImpl;
import com.social.services.SkillsServiceImpl;





@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/experiences")
public class ExperienceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExperienceServiceImpl experienceService;
	@Autowired
	private ExperienceDao experienceDao;
	@RequestMapping(value = "/addExperience", method = RequestMethod.POST)
	public ResponseEntity<?> createExperience(@RequestBody Experience newExperience) {
	
		return new ResponseEntity<Experience>(experienceService.save(newExperience), HttpStatus.CREATED);
	}
	@RequestMapping(value = "/experiences", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Experience>> getAllExperiences(){
    	logger.debug("Invocation de la resource : GET /experiences");
    	List<Experience> experiences = experienceService.getAllExperiences();
    	if(experiences.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(experiences, HttpStatus.OK);
    }
    @RequestMapping(value = "/experiences/{idExperience}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Experience> getExperienceById(@PathVariable("idExperience") Long idExperience) {
    	logger.debug("Invocation de la resource : GET /experiences/{idExperience}");
    	
    	Experience experience = experienceService.getExperienceById(idExperience);
    	if(experience == null){
    		logger.info("Impossible de trouver le experience");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(experience, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/experiences/{idExperience}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteExperience(@PathVariable("idExperience") Long idExperience){
    	logger.debug("Invocation de la resource : DELETE /experiences/");
    	experienceDao.delete(idExperience);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	@RequestMapping(value="/experiences",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Experience updateExperience(@RequestBody Experience experience) {
		return experienceDao.save(experience);
	}
}
