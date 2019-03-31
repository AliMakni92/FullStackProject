package com.social.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "Project")
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProject",updatable=false,nullable=false)
	private Long idProject;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	private Long dureeProject;
	/**
	 * Description of the property name.
	 */
	@Column(unique=true)
	private String name;
	private String city;
	/**
	 * Description of the property description.
	 */
	private String description;
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;
	private int idCollaborater;
	///if user=collaborater
	//@OneToMany(mappedBy = "collaborater")
    //private List<Project> colprojects;
	//@ManyToOne
	//@JoinColumn(name = "idCollaborateur", nullable = false)
	//@JsonIgnore
	//private User collaborater;
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExperience", nullable = false)
	@JsonIgnore
	private Experience experience;*/
	@JsonIgnore
	@ManyToMany(mappedBy="projects")
	private List<Skills> skills;
	public Project() {

	}

	public Project(Date startDate, String city, Long dureeProject, String name, String description, Date created, Date updated) {
		super();
		this.startDate = startDate;
		this.city=city;
		this.dureeProject = dureeProject;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
	}
	
	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

/*	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}*/

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getDureeProject() {
		return dureeProject;
	}

	public void setDureeProject(Long dureeProject) {
		this.dureeProject = dureeProject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getIdCollaborater() {
		return idCollaborater;
	}

	public void setIdCollaborater(int idCollaborater) {
		this.idCollaborater = idCollaborater;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	/*public List<Project> getColprojects() {
		return colprojects;
	}*/
/*
	public void setColprojects(List<Project> colprojects) {
		this.colprojects = colprojects;
	}*/
/*
	public User getCollaborater() {
		return collaborater;
	}

	public void setCollaborater(User collaborater) {
		this.collaborater = collaborater;
	}*/

}
