package com.social.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.social.dao.AffectaionDao;
import com.social.dao.MissionDao;
import com.social.dao.UserRepository;
import com.social.entities.Affectation;
import com.social.entities.Mission;

@CrossOrigin("*")
@Service
public class AffectationService {
	@Autowired
	AffectaionDao affectaionDao;
	@Autowired
	MissionDao missionDao;
	/*public void addAffectationandAssignToMission(Affectation affectation,Long idMission) {
		affectation.setMissionAffect(new Mission(idMission));
		affectaionDao.save(affectation);
	}*/
	public void addMissionandAssignToAffectation(Mission mission, Long idCollaborater) {
		
		Affectation affectation = new Affectation();
		affectation.setIdCollaborater(idCollaborater);
		/*List<Mission> missions = new ArrayList<>();
		missions.add(mission);
		affectation.setMissions(missions);*/
		affectation.setMission(mission);
		affectaionDao.save(affectation);
	}
	public List<Affectation> getAllAffectations() {
		// TODO Auto-generated method stub
		return (List<Affectation>) affectaionDao.findAll();
	}
	public Affectation addAffectation(Affectation affectation) {
		
		//affectation = new Affectation();
		//affectation.setIdCollaborater(idCollaborater);
		/*List<Mission> missions = new ArrayList<>();
		missions.add(mission);
		affectation.setMissions(missions);*/
		affectation.setStatus(true);
		return affectaionDao.save(affectation);
	}
	public boolean isExist(Long idCollaborater, Long idMission) {
		// TODO Auto-generated method stub
		return affectaionDao.countAffectation(idCollaborater, idMission)>0;
	}
	public Affectation getAffectationById(Long idAffectation) {
		// TODO Auto-generated method stub
		
		return affectaionDao.findOne(idAffectation);
	}

	public Affectation makeStatusTrue(Affectation affectation) {
		affectation.setStatus(true);
		return affectaionDao.save(affectation);
		// TODO Auto-generated method stub
		
	}
	public Affectation makeConfirmTrue(Affectation affectation) {
		affectation.setConfirm(true);
		return affectaionDao.save(affectation);
		// TODO Auto-generated method stub
		
	}
}
