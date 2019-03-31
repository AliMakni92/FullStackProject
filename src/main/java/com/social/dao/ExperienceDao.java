package com.social.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Experience;
import com.social.entities.Skills;

@Repository
public interface ExperienceDao extends CrudRepository<Experience, Long> {
	/*Collaborater save(Collaborater user);

	Collaborater findByUserName(String username);*/
}
