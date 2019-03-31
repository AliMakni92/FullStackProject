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
@Table(name = "Mission")
public class Mission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMission;
	/**
	 * Description of the property type.
	 */
	private String type;
	@Temporal(TemporalType.DATE)
   	private Date startDate;
	/**
	 * Description of the property duration.
	 */
	private Integer duration;
	/**
	 * Description of the property description.
	 */
	private String description;
	/**
	 * Description of the property postNumber.
	 */
	private Integer postNumber;
	private String nameSkills;
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;
	private int idPartenaire;
	private Integer sum;
	/*@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,mappedBy="missionAffect")
	@JsonIgnore
	private List<Affectation> affectationMission;*/
/*	@ManyToOne
	@JoinColumn(name = "idAffectation", referencedColumnName = "idAffectation", updatable = false, insertable = false, nullable = true)
	private Affectation affectation;*/
	@OneToMany(mappedBy = "missionAddict")
	@JsonIgnore
	private List<Addiction> addictionMission;
	@OneToMany(mappedBy = "mission")
	@JsonIgnore
	private List<Affectation> affectationmissions;
	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mission(Long idMission) {
		super();
		this.idMission = idMission;
	}

	public Mission(String type, Date startDate, Integer duration, String description,
			Integer postNumber, Date created, Date updated) {
		super();
		this.type = type;
		this.startDate = startDate;
		this.duration = duration;
		this.description = description;
		this.postNumber = postNumber;
		this.created = created;
		this.updated = updated;
	}
	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(Integer postNumber) {
		this.postNumber = postNumber;
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
/*	}
	public List<Affectation> getAffectationMission() {
		return affectationMission;
	}
	public void setAffectationMission(List<Affectation> affectationMission) {
		this.affectationMission = affectationMission;
	}*/
	public List<Addiction> getAddictionMission() {
		return addictionMission;
	}
	public void setAddictionMission(List<Addiction> addictionMission) {
		this.addictionMission = addictionMission;
	}

	public int getIdPartenaire() {
		return idPartenaire;
	}
	public void setIdPartenaire(int idPartenaire) {
		this.idPartenaire = idPartenaire;
	}

	public String getNameSkills() {
		return nameSkills;
	}

	public void setNameSkills(String nameSkills) {
		this.nameSkills = nameSkills;
	}

	public List<Affectation> getAffectationmissions() {
		return affectationmissions;
	}

	public void setAffectationmissions(List<Affectation> affectationmissions) {
		this.affectationmissions = affectationmissions;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}


/*	public void addAffectation(Affectation affectation) {
		if(null == affectationMission)
			affectationMission = new ArrayList<>();
		
		affectationMission.add(affectation);
		
	}*/
	

}
