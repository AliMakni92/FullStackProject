package com.social.controller;

import java.security.Principal;
import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.services.UserService;
import com.social.util.CustomErrorType;
import com.social.dao.UserRepository;
import com.social.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author kamal berriga
 *
 */
@CrossOrigin
@RestController
@RequestMapping("account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	// request method to create a new account by a guest

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		if (userService.findByfullName(newUser.getFullName()) != null) {
			logger.error("fullName Already exist " + newUser.getFullName());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getFullName() + "already exist "),
					HttpStatus.CONFLICT);
		}
		if (newUser.getRepeatpassword() != null && !newUser.getRepeatpassword().equals(newUser.getPassword())) {
			logger.error("password non confirmé  " + newUser.getPassword());
			return new ResponseEntity(
					new CustomErrorType("user with password " + newUser.getPassword() + "not confirmed "),
					HttpStatus.CONFLICT);
		}
		newUser.setRole("COLLABORATEUR");
		newUser.setEnabled(true);
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/addPartenaire", method = RequestMethod.POST)
	public ResponseEntity<?> createPartenaire(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		if (userService.findByfullName(newUser.getFullName()) != null) {
			logger.error("fullName Already exist " + newUser.getFullName());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getFullName() + "already exist "),
					HttpStatus.CONFLICT);
		}
		if (newUser.getRepeatpassword() != null && !newUser.getRepeatpassword().equals(newUser.getPassword())) {
			logger.error("password non confirmé  " + newUser.getPassword());
			return new ResponseEntity(
					new CustomErrorType("user with password " + newUser.getPassword() + "not confirmed "),
					HttpStatus.CONFLICT);
		}
		/*
		 * if(userService.findBycountry(newUser.getCountry())!=null &&
		 * !newUser.getCountry().equals("France")) {
		 * logger.error("country shoud be France "); return new ResponseEntity( new
		 * CustomErrorType("user with country " + newUser.getCountry() +
		 * "already not equal to France "), HttpStatus.CONFLICT); }
		 */
		newUser.setRole("PARTENAIRE");
		newUser.setEnabled(true);
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		logger.debug("Invocation de la resource : GET /users");
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{roles}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers(String roles) {
		logger.debug("Invocation de la resource : GET /users");
		List<User> users = userService.getAllUserByRoles(roles);
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		logger.debug("Invocation de la resource : GET /users/{userId}");

		User user = userService.getUserById(userId);
		if (user == null) {
			logger.info("Impossible de trouver le user");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUer(@PathVariable("userId") Long userId) {
		logger.debug("Invocation de la resource : DELETE /user/");
		userRepository.delete(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable("userId") Long userId) {
		logger.debug("Invocation de la resource : PUT /user/{userId}");
		try {
			userService.bloquerdebloquerUser(userId, user);
		} catch (NoResultException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String isenabled(@RequestBody User user, @PathVariable("userId") Long userId) {

		if (userRepository.getOne(userId).isEnabled()) {
			return "ok";
		} else {
			return "no";
		}

	}
	// this is the login api/service

	@RequestMapping("/login")
	public Principal user(Principal principal) {

		logger.info("user logged " + principal);
		return principal;
	}

	@RequestMapping(value = "/payer/{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> payer(@RequestBody User user, @PathVariable("userId") Long userId) {

		return new ResponseEntity<User>(userService.payer(10, user), HttpStatus.OK);
	}
}
