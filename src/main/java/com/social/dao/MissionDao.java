package com.social.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Mission;
import com.social.entities.Skills;

@Repository
public interface MissionDao extends CrudRepository<Mission, Long> {

}
