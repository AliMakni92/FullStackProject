package com.social.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "Experience")
public class Experience implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExperience;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	private Long duree;
	/**
	 * Description of the property locale.
	 */
	private String locale;
	/**
	 * Description of the property city.
	 */
	private String city;
	/**
	 * Description of the property country.
	 */
	private String country;
	/**
	 * Description of the property comment
	 */
	private String comment;
	private String nameSkillsExp;
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;
	private int idCollaborater;
	/*
	 * @ManyToOne private Collaborater collaborater;
	 */

	//@ManyToOne
	//@JoinColumn(name = "idCollaborater",referencedColumnName="userId")
	//private User collaboraterp;

	/*@OneToMany(mappedBy = "experience")
	private List<Project> projects;*/
////////////////////


	public Experience() {

	}

	public Experience(Date startDate, Long duree, String locale, String city, String country, String comment,
			Date created, Date updated) {
		super();
		this.startDate = startDate;
		this.duree = duree;
		this.locale = locale;
		this.city = city;
		this.country = country;
		this.comment = comment;
		this.created = created;
		this.updated = updated;
	}

	public Long getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(Long idExperience) {
		this.idExperience = idExperience;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

/*	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
*/
	



	public Experience(Long idExperience) {
		super();
		this.idExperience = idExperience;
	}
/*
	public User getCollaboraterp() {
		return collaboraterp;
	}

	public void setCollaboraterp(User collaboraterp) {
		this.collaboraterp = collaboraterp;
	}

	*/

	public int getIdCollaborater() {
		return idCollaborater;
	}

	public void setIdCollaborater(int idCollaborater) {
		this.idCollaborater = idCollaborater;
	}

	public String getNameSkillsExp() {
		return nameSkillsExp;
	}

	public void setNameSkillsExp(String nameSkillsExp) {
		this.nameSkillsExp = nameSkillsExp;
	}
	

}