package com.social.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	@Temporal(TemporalType.DATE)
   	private Date datebirthday;
	private String name;
	private String genre;
	private String pays;
	private String etat;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Date getDatebirthday() {
		return datebirthday;
	}
	public void setDatebirthday(Date datebirthday) {
		this.datebirthday = datebirthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Date datebirthday, String name, String genre, String pays, String etat) {
		super();
		this.datebirthday = datebirthday;
		this.name = name;
		this.genre = genre;
		this.pays = pays;
		this.etat = etat;
	}
	
}
