package com.social.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Affectation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAffectation;
	private Long idCollaborater;
	/*@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,mappedBy="affectation")
	@JsonIgnore
	private List<Mission> missions;*/
	@ManyToOne
	//@JoinColumn(name = "idMission", referencedColumnName = "idMission", updatable = false, insertable = false, nullable = true)
	private Mission mission;
	private boolean status; 
	private boolean confirm;

	public Affectation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdAffectation() {
		return idAffectation;
	}

	public void setIdAffectation(Long idAffectation) {
		this.idAffectation = idAffectation;
	}





	public Long getIdCollaborater() {
		return idCollaborater;
	}

	public void setIdCollaborater(Long idCollaborater) {
		this.idCollaborater = idCollaborater;
	}


	
	
	



	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Affectation(Long idAffectation) {
		super();
		this.idAffectation = idAffectation;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}



	





}
