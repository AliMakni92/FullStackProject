package com.social.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.social.dao.ExperienceDao;
import com.social.dao.MissionDao;
import com.social.dao.SkillsDao;
import com.social.entities.Experience;
import com.social.entities.Mission;
import com.social.entities.Skills;
import com.social.entities.User;


@CrossOrigin("*")
@Service
public class MissionServiceImpl {

	@Autowired
	private MissionDao missionDao;

	public Mission save(Mission mission) {
		return missionDao.save(mission);
	}
	public List<Mission> getAllMissions() {
		// TODO Auto-generated method stub
		return (List<Mission>) missionDao.findAll();
	}

	public Mission getMissionById(Long idMission) {
		// TODO Auto-generated method stub
		return missionDao.findOne(idMission);
	}
	
	public void deleteMission(Long idMission) {
		missionDao.delete(idMission);
	}
	public Mission decrementernumber(Mission mission) {
		Integer s=mission.getPostNumber();
		s=s-1;
		mission.setPostNumber(s);
		return missionDao.save(mission);
	}

}
