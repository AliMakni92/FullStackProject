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
@Table(name = "Skills")
public class Skills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSkills;
	/**
	 * Description of the property name.
	 */
	private String name;
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;
	@ManyToMany(cascade=CascadeType.MERGE)
	private List<Project> projects;
	@OneToMany(mappedBy = "skillsAddict")
	private List<Addiction> addictSkills;
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skills(String name, Date created, Date updated) {
		super();
		this.name = name;
		this.created = created;
		this.updated = updated;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Long getIdSkills() {
		return idSkills;
	}

	public void setIdSkills(Long idSkills) {
		this.idSkills = idSkills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Addiction> getAddictSkills() {
		return addictSkills;
	}

	public void setAddictSkills(List<Addiction> addictSkills) {
		this.addictSkills = addictSkills;
	}

}
