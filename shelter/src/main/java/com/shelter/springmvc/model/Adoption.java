package com.shelter.springmvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


/*
 * id bigint
 * aName varchar(30) nn
 * age varchar(2) nn
 * species varchar(30) nn 
 * breed varchar(30) nn 
 * adopterName varchar(45) nn
 * adoptDate datetime nn 
 * address varchar(45) nn 
 * telnum varchar(15) nn*/
@Entity
@Table(name="ADOPTION")
public class Adoption {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="ANAME", nullable=false)
	private String aName;
		
	@NotEmpty
	@Column(name="AGE", nullable=false)
	private String age;

	@NotEmpty
	@Column(name="SPECIES", nullable=false)
	private String species;

	@NotEmpty
	@Column(name="BREED", nullable=false)
	private String breed;

	@NotEmpty
	@Column(name="ADOPTERNAME", nullable=false)
	private String adopterName;

	
	@Column(name="ADOPTDATE", nullable=false)
	private String adoptDate;
	
	@NotEmpty
	@Column(name="ADDRESS", nullable=false)
	private String address;

	@NotEmpty
	@Column(name="TELNUM", nullable=false)
	private String telnum;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getaName() {
		return aName;
	}


	public void setaName(String aName) {
		this.aName = aName;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getAdopterName() {
		return adopterName;
	}


	public void setAdopterName(String adopterName) {
		this.adopterName = adopterName;
	}


	public String getAdoptDate() {
		return adoptDate;
	}


	public void setAdoptDate(String adoptDate) {
		this.adoptDate = adoptDate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTelnum() {
		return telnum;
	}


	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}


	@Override
	public String toString() {
		return "Adoption [id=" + id + ", aName=" + aName + ", age=" + age
				+ ", species=" + species + ", breed=" + breed + ", adopterName=" + adopterName + ", adoptDate=" + adoptDate + ", address=" 
				+ address + ",telnum=" + telnum +"]";
	}

}
