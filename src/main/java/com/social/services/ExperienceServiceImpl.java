package com.social.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.social.dao.ExperienceDao;
import com.social.dao.SkillsDao;
import com.social.entities.Experience;
import com.social.entities.Skills;


@Service
@CrossOrigin("*")
public class ExperienceServiceImpl {

	@Autowired
	private ExperienceDao experienceDao;

	public Experience save(Experience experience) {
		return experienceDao.save(experience);
	}
	public List<Experience> getAllExperiences() {
		// TODO Auto-generated method stub
		return (List<Experience>) experienceDao.findAll();
	}

	public Experience getExperienceById(Long idExperience) {
		// TODO Auto-generated method stub
		return experienceDao.findOne(idExperience);
	}
	
	public void deleteExperience(Long idExperience) {
		experienceDao.delete(idExperience);
	}

}
