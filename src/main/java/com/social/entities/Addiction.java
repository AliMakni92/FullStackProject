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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Addiction implements Serializable{
	@EmbeddedId
	private AddictionId addictionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSkills", referencedColumnName = "idSkills", updatable = false, insertable = false, nullable = false)
	private Skills skillsAddict;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMission", referencedColumnName = "idMission", updatable = false, insertable = false, nullable = false)
	private Mission missionAddict;
	/**
	 * Description of the property coef.
	 */
	private Float coef;
	/**
	 * Description of the property duration.
	 */
	private int duration;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	public Addiction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Addiction(Skills skillsAddict, Mission missionAddict, Float coef, int duration, Date created, Date updated) {
		super();
		this.addictionId = new AddictionId(skillsAddict.getIdSkills(), missionAddict.getIdMission());
		this.skillsAddict = skillsAddict;
		this.missionAddict = missionAddict;
		this.coef = coef;
		this.duration = duration;
		this.created = created;
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Addiction [addictionId=" + addictionId + ", skillsAddict=" + skillsAddict + ", missionAddict="
				+ missionAddict + ", coef=" + coef + ", duration=" + duration + ", created=" + created + ", updated="
				+ updated + "]";
	}

	public AddictionId getAddictionId() {
		return addictionId;
	}

	public void setAddictionId(AddictionId addictionId) {
		this.addictionId = addictionId;
	}

	public Skills getSkillsAddict() {
		return skillsAddict;
	}

	public void setSkillsAddict(Skills skillsAddict) {
		this.skillsAddict = skillsAddict;
	}

	public Mission getMissionAddict() {
		return missionAddict;
	}

	public void setMissionAddict(Mission missionAddict) {
		this.missionAddict = missionAddict;
	}

	public Float getCoef() {
		return coef;
	}

	public void setCoef(Float coef) {
		this.coef = coef;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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

}
