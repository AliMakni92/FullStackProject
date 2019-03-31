package com.social.entities;

/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.mapping.Set;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Description of User.
 * 
 * @author MAKNI Ali
 */
@Entity
@Table(name = "User")
@Scope("session")
public class User implements UserDetails {
	public static enum Role {
		USER
	}

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	/**
	 * Description of the property email.
	 */
	@Column(unique = true)
	private String username;
	/**
	 * Description of the property password.
	 */
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String repeatpassword;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
	private String roles;
	/**
	 * Description of the property full name.
	 */
	@Column(unique=true)
	private String fullName;
	public User(Long userId, String username, String password, String repeatpassword, String fullName, Integer solde) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.repeatpassword = repeatpassword;
		this.fullName = fullName;
		this.solde = solde;
	}


	private boolean enabled;
	/**
 	 * Description of the property address.
 	 */
   	private String address;
   	/**
	 * Description of the property city.
	 */
  	private String city;
	/**
	 * Description of the property country.
	 */
	private String country;
	/**
	 * Description of the property description.
	 */
	private String descriptionPartenaire;

	/**
	 * Description of the property email contact.
	 */
	private String emailContact;
	/**
	 * Description of the property website.
	 */
	private String website;
	/**
	 * Description of the property telephone.
	 */
	private String telephone;
	@NotNull
	private Integer solde=100;
	@CreationTimestamp
    private Date created;
	@CreationTimestamp
    private Date updated;

	public User() {

	}

	
	public User(Long userId) {
		super();
		this.userId = userId;
	}


	public User(Long userId, String username, String password, String roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public User(String username, String password, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String fullName,String username, String password, String roles, boolean enabled) {
		super();
		this.fullName=fullName;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
	}

	public User(String fullName,String username, String password, String roles, boolean enabled, String address,
			String city, String country) {
		super();
		this.fullName=fullName;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
		this.address = address;
		this.city = city;
		this.country = country;
	}

	public User(String fullName,String username, String password, String roles, boolean enabled, String address, String city,
			String country, String descriptionPartenaire, String emailContact, String website, String telephone) {
		super();
		this.fullName=fullName;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
		this.address = address;
		this.city = city;
		this.country = country;
		this.descriptionPartenaire = descriptionPartenaire;
		this.emailContact = emailContact;
		this.website = website;
		this.telephone = telephone;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(roles));
		return authorities;
	}

	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getRoles() {
		return roles;
	}

	public void setRole(String roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescriptionPartenaire() {
		return descriptionPartenaire;
	}

	public void setDescriptionPartenaire(String descriptionPartenaire) {
		this.descriptionPartenaire = descriptionPartenaire;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getRepeatpassword() {
		return repeatpassword;
	}


	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}


	public Integer getSolde() {
		return solde;
	}


	public void setSolde(Integer solde) {
		this.solde = solde;
	}


	

	


}
