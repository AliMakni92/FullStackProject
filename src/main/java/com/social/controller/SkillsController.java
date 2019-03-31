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

import com.social.dao.SkillsDao;
import com.social.entities.Skills;

import com.social.services.SkillsServiceImpl;





@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/skills")
public class SkillsController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SkillsServiceImpl skillsService;
	@Autowired
	private SkillsDao skillsDao;
	@RequestMapping(value = "/addSkills", method = RequestMethod.POST)
	public ResponseEntity<?> createSkills(@RequestBody Skills newSkills) {
	
		return new ResponseEntity<Skills>(skillsService.save(newSkills), HttpStatus.CREATED);
	}
	@RequestMapping(value = "/skillss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Skills>> getAllSkillss(){
    	logger.debug("Invocation de la resource : GET /skillss");
    	List<Skills> skills = skillsService.getAllSkills();
    	if(skills.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    @RequestMapping(value = "/skillss/{idSkills}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skills> getSkillsById(@PathVariable("idSkills") Long idSkills) {
    	logger.debug("Invocation de la resource : GET /skillss/{idSkills}");
    	
    	Skills skills = skillsService.getSkillsById(idSkills);
    	if(skills == null){
    		logger.info("Impossible de trouver le skills");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(skills, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/skillss/{idSkills}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSkills(@PathVariable("idSkills") Long idSkills){
    	logger.debug("Invocation de la resource : DELETE /skills/");
    	skillsDao.delete(idSkills);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
