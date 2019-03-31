package com.social.controller;

import java.util.List;

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

import com.social.dao.AffectaionDao;
import com.social.entities.Affectation;
import com.social.entities.Mission;
import com.social.services.AffectationService;
import com.social.services.MissionServiceImpl;
import com.social.util.CustomErrorType;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/affectations")
public class AffectationController {
	@Autowired
	private AffectationService affectationService;
	@Autowired
	private AffectaionDao affectaionDao;
	
	@Autowired
	private MissionServiceImpl missionService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/*@RequestMapping(value = "/addAffectation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAffectation(@RequestBody Affectation affectation, 
    									  @RequestParam("idMission") Long idMission){
    	logger.debug("Invocation de la resource : POST /affectation/");
    	affectaionDao.save(affectation);
    	return new ResponseEntity<>(HttpStatus.OK);
    }*/
	@RequestMapping(value = "/addAffectation/{idCollaborater}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addAffectation(@RequestBody Mission mission,@PathVariable("idCollaborater") Long idCollaborater) {
		
		
		if(affectationService.isExist(idCollaborater,mission.getIdMission())) {
			return new ResponseEntity(new CustomErrorType("Vous ete déja affecté"),HttpStatus.CONFLICT);
		}
		
		if(mission.getPostNumber()==0) {
			logger.error("postnumber egale à zero impossible de faire l'ajout ");
			return new ResponseEntity(
					new CustomErrorType("mission with postnumber " + mission.getPostNumber()),
					HttpStatus.CONFLICT);
		}
		Mission missionData = missionService.getMissionById(mission.getIdMission());
		missionService.decrementernumber(missionData);
		affectationService.addMissionandAssignToAffectation(mission,idCollaborater);
		return new ResponseEntity(new CustomErrorType("Succées") , HttpStatus.OK);
	}
	@RequestMapping(value = "/affectations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Affectation>> getAllAffectation(){
    	logger.debug("Invocation de la resource : GET /affectations");
    	List<Affectation> affectations = affectationService.getAllAffectations();
    	if(affectations.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(affectations, HttpStatus.OK);
    }
	@RequestMapping(value="/updateaffectation/{idAffectation}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Affectation updateAffectation(@PathVariable("idAffectation") Long idAffectation,@RequestBody Affectation affectation) {
		affectation = affectationService.getAffectationById(idAffectation);
    	return affectationService.makeConfirmTrue(affectation);
	}
	
}
