package com.shelter.springmvc.service;

import java.util.List;

import com.shelter.springmvc.model.Adoption;

public interface AdoptionService {
	Adoption findById(int id);
	
	Adoption findByAnimalName(String aName);
	
	Adoption findByAdopterName(String adopterName);

	void saveAdoption(Adoption animal);
	
	void updateAdoption(Adoption animal);
	
	void deleteAdoptionById(int id);

	List<Adoption> findAllAdoptions();  //order by adoptername
	
	List<Adoption> findAllAnimals(); //order by animalsname

	//boolean isUserSSOUnique(Integer id, String sso);
}
