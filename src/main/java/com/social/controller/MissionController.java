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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ExperienceDao;
import com.social.dao.MissionDao;
import com.social.dao.SkillsDao;
import com.social.services.AffectationService;
import com.social.services.ExperienceServiceImpl;
import com.social.services.MissionServiceImpl;
import com.social.services.SkillsServiceImpl;
import com.social.util.CustomErrorType;
import com.social.entities.Affectation;
import com.social.entities.Mission;
import com.social.entities.Project;
import com.social.entities.User;




@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/missions")
public class MissionController {
	Long i=(long) 1;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MissionServiceImpl missionService;
	@Autowired
	private MissionDao missionDao;
	@Autowired
	private AffectationService affectationService;
	@RequestMapping(value = "/addMissionandAssignToAffectation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMissionandAssignToAffectation(@RequestBody Mission newMission, @RequestParam("idAffectation") Long idAffectation) {
		logger.debug("Invocation de la resource : POST /mission/");
		//Long idAffectation = (long) 1;
		affectationService.addMissionandAssignToAffectation(newMission, idAffectation);
		//Affectation affectation=new Affectation(idAffectation);
		//affectation.setIdAffectation(idAffectation);
		//newMission.setAffectation(affectation);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addMission", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMission(@RequestBody Mission newMission) {
	
		return new ResponseEntity<Mission>(missionService.save(newMission), HttpStatus.CREATED);
	}
	@RequestMapping(value = "/missions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Mission>> getAllMissions(){
    	logger.debug("Invocation de la resource : GET /missions");
    	List<Mission> missions = missionService.getAllMissions();
    	if(missions.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(missions, HttpStatus.OK);
    }
    @RequestMapping(value = "/missions/{idMission}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mission> getMissionById(@PathVariable("idMission") Long idMission) {
    	logger.debug("Invocation de la resource : GET /missions/{idMission}");
    	
    	Mission mission = missionService.getMissionById(idMission);
    	if(mission == null){
    		logger.info("Impossible de trouver le mission");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(mission, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/missions/{idMission}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMission(@PathVariable("idMission") Long idMission){
    	logger.debug("Invocation de la resource : DELETE /missions/");
    	missionDao.delete(idMission);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	@RequestMapping(value="/missions",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mission updateMission(@RequestBody Mission mission) {
		
		return missionDao.save(mission);
	}
	
}
