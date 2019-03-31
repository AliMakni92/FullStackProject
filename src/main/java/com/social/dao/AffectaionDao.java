package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social.entities.Affectation;
import com.social.entities.Mission;
import com.social.entities.User;

@Repository
public interface AffectaionDao extends CrudRepository<Affectation, Long> {
	
	
	 @Query("Select count(a) from Affectation a where a.idCollaborater=:idCollaborater and a.mission.idMission=:idMission")
	  long countAffectation(@Param("idCollaborater") Long idCollaborater,@Param("idMission") Long idMission);
	
	// public List<Affectation> findByIdCollaboraterAndId_Mission(Long idCollaborater,Mission mission);

}
