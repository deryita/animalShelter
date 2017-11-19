package com.shelter.springmvc.dao;

import java.util.List;

import com.shelter.springmvc.model.Adoption;

public interface AdoptionDao {
	Adoption findById(int id);
	
	Adoption findByAnimalName(String name);
	
	Adoption findByAdopterName(String name);
	
	//Adoption findByAdoptionDate(String date); Maybe do this later.

	void save(Adoption adoption);
	
	void deletebyID(int id);
	
	List<Adoption> findAllAdoptions();


}
