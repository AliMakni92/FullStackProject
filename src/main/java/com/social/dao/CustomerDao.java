package com.social.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Customer;
import com.social.entities.Skills;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {
	/*Collaborater save(Collaborater user);

	Collaborater findByUserName(String username);*/
}
