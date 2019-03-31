package com.social.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Abonnement;

@Repository
public interface AbonnementDao extends CrudRepository<Abonnement, Long>{

}
