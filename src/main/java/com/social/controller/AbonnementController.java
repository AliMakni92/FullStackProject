package com.social.controller;

import java.util.Date;

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

import com.social.dao.AbonnementDao;
import com.social.entities.Abonnement;
import com.social.entities.User;



@CrossOrigin
@RestController
@RequestMapping("/abonnements")
public class AbonnementController {
	@Autowired
	private AbonnementDao abonnementDao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value="/abonnement/{idadmin}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> ajouterAbonnement(@RequestBody User partenaire,@PathVariable("idadmin") Long idadmin){
		Abonnement abonement = new Abonnement();
		abonement.setPartenaire(partenaire);
		abonement.setIdadmin(idadmin);
		abonement.setDateAbonnement(new Date());
		abonement.setDuree(1);
		abonnementDao.save(abonement);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    @RequestMapping(value = "/abonnement/{idAbonnement}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAbonnement(@PathVariable("idAbonnement") Long idAbonnement){
    	logger.debug("Invocation de la resource : DELETE /abonnement/");
    	abonnementDao.delete(idAbonnement);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
