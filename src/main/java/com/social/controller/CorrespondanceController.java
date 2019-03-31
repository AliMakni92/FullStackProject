package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.ExperienceDao;
import com.social.dao.MissionDao;
import com.social.entities.Experience;
import com.social.entities.Mission;
import com.social.services.ExperienceServiceImpl;
import com.social.services.MissionServiceImpl;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/correspondances")
public class CorrespondanceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExperienceServiceImpl experienceService;
	@Autowired
	private ExperienceDao experienceDao;
	@Autowired
	private MissionServiceImpl missionService;
	@Autowired
	private MissionDao missionDao;
	@RequestMapping(value = "/corespondance", method = RequestMethod.POST)
	public String missionExperience(Long userId) {
		List<Mission> missions_all=(List<Mission>) missionDao.findAll();
		List<Experience> experiences_all=(List<Experience>) experienceDao.findAll();
		List<Experience> exps=new ArrayList<>();
		List<Mission>miss=new ArrayList<>();
		for(int i=0;i<missions_all.size();i++) {
			if(missions_all.get(i).getIdPartenaire()==userId) {
				miss.add(missions_all.get(i));
			}
		}
		for(int i=0;i<experiences_all.size();i++) {
			if(experiences_all.get(i).getIdCollaborater()==userId) {
				exps.add(experiences_all.get(i));
			}
		}	
		String f="";
		
			for(int i=0;i<miss.size();i++) {
				for(int j=0;j<exps.size();j++) {
					if(exps.get(j).getNameSkillsExp().equals(miss.get(i).getNameSkills())) {
						f=f+exps.get(j).getNameSkillsExp()+" ";
					}
				}
			}
		return f;
		
	}
}
