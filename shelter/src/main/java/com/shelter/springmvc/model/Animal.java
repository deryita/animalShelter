package com.shelter.springmvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ANIMAL")
public class Animal {

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
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", aName=" + aName + ", age=" + age
				+ ", species=" + species + ", breed=" + breed + "]";
	}

}
