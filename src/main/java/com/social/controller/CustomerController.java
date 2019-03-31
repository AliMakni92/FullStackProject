package com.social.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.social.dao.CustomerDao;
import com.social.dao.SkillsDao;
import com.social.entities.Customer;
import com.social.entities.Skills;

import com.social.services.SkillsServiceImpl;





@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerDao customerDao;
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer newCustomer) {
	
		return new ResponseEntity<Customer>(customerDao.save(newCustomer), HttpStatus.CREATED);
	}

}
