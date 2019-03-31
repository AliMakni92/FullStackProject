package com.social.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.social.dao.UserRepository;
import com.social.entities.User;
/** 
 * @author MAKNI Ali
 *
 */
@CrossOrigin("*")
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findOneByUsername(userName);
	}
	public User findByfullName(String fullName) {
		return userRepository.findOneByFullName(fullName);
	}
	public User findBycountry(String country) {
		return userRepository.findOneByCountry(country);
	}
	public User find(Long id) {
		return userRepository.findOne(id);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}
	public List<User> getAllUserByRoles(String roles) {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findOneByRoles(roles);
	}
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Transactional
	public void bloquerdebloquerUser(Long userId, User user) {
		// TODO Auto-generated method stub
		User userManagedEntity=userRepository.findOne(userId);
                System.out.println(userManagedEntity  == null);
		if(userManagedEntity == null){
			throw new NoResultException();
		}else if(userManagedEntity.isEnabled()==true) {
			userManagedEntity.setEnabled(false);
                        System.out.println("data changed");
                        userRepository.save(userManagedEntity);
                        System.out.println("data saved");
		}else if(userManagedEntity.isEnabled()==false) {
			userManagedEntity.setEnabled(true);
                        userRepository.save(userManagedEntity);
		}
	}
	public User payer(Integer solde,User user) {
		Integer s=user.getSolde();
		s=s-solde;
		user.setSolde(s);
		return userRepository.save(user);
	}
}
