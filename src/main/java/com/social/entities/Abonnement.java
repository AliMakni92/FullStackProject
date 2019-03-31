package com.social.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Abonnement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAbonnement;
	@Temporal(TemporalType.DATE)
	private Date dateAbonnement;
	private Integer duree;
	@OneToOne
	private User partenaire;
	private Long idadmin;//user connecté 
	public Long getIdAbonnement() {
		return idAbonnement;
	}
	public void setIdAbonnement(Long idAbonnement) {
		this.idAbonnement = idAbonnement;
	}
	public Date getDateAbonnement() {
		return dateAbonnement;
	}
	public void setDateAbonnement(Date dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public User getPartenaire() {
		return partenaire;
	}
	public void setPartenaire(User partenaire) {
		this.partenaire = partenaire;
	}
	public Long getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(Long idadmin) {
		this.idadmin = idadmin;
	}



	
	
}
