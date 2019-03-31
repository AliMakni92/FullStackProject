package com.social.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class AddictionId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long idSkills;
	private long idMission;
	public AddictionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddictionId(long idSkills, long idMission) {
		super();
		this.idSkills = idSkills;
		this.idMission = idMission;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMission ^ (idMission >>> 32));
		result = prime * result + (int) (idSkills ^ (idSkills >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddictionId other = (AddictionId) obj;
		if (idMission != other.idMission)
			return false;
		if (idSkills != other.idSkills)
			return false;
		return true;
	}
	public long getIdSkills() {
		return idSkills;
	}
	public void setIdSkills(long idSkills) {
		this.idSkills = idSkills;
	}
	public long getIdMission() {
		return idMission;
	}
	public void setIdMission(long idMission) {
		this.idMission = idMission;
	}
	

}