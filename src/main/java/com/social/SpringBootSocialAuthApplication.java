package com.social;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.social.dao.AffectaionDao;
import com.social.dao.MissionDao;
import com.social.dao.UserRepository;
import com.social.entities.Affectation;
import com.social.entities.Mission;
import com.social.entities.User;
import com.social.services.MissionServiceImpl;
import com.social.services.UserService;
/**
 * 
 * @author MAKNI Ali
 *
 */
@SpringBootApplication
public class SpringBootSocialAuthApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSocialAuthApplication.class, args);
	}


}
