package com.social.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Skills;

@Repository
public interface SkillsDao extends CrudRepository<Skills, Long> {
	/*Collaborater save(Collaborater user);

	Collaborater findByUserName(String username);*/
}
