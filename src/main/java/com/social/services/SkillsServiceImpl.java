package com.social.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.social.dao.SkillsDao;
import com.social.entities.Skills;


@CrossOrigin("*")
@Service
public class SkillsServiceImpl {

	@Autowired
	private SkillsDao skillsDao;

	public Skills save(Skills skills) {
		return skillsDao.save(skills);
	}
	public List<Skills> getAllSkills() {
		// TODO Auto-generated method stub
		return (List<Skills>) skillsDao.findAll();
	}

	public Skills getSkillsById(Long idSkills) {
		// TODO Auto-generated method stub
		return skillsDao.findOne(idSkills);
	}
	
	public void deleteSkills(Long idSkills) {
		skillsDao.delete(idSkills);
	}

}
