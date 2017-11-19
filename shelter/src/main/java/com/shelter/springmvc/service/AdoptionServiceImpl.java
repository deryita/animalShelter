package com.shelter.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shelter.springmvc.dao.AdoptionDao;
import com.shelter.springmvc.dao.UserDao;
import com.shelter.springmvc.model.Adoption;
import com.shelter.springmvc.model.User;

@Service("adoptionService")
@Transactional
public class AdoptionServiceImpl implements AdoptionService {

	@Autowired
	private AdoptionDao dao;

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

	@Override
	public Adoption findById(int id) {
		return dao.findById(id);

	}

	@Override
	public Adoption findByAnimalName(String name) {
		Adoption adoption = dao.findByAnimalName(name);
		return adoption;
	}
	
	@Override
	public Adoption findByAdopterName(String name) {
		Adoption adoption = dao.findByAdopterName(name);
		return adoption;
	}

	@Override
	public void updateAdoption(Adoption adoption) {
		Adoption entity = dao.findById(adoption.getId());
		if(entity!=null){
			entity.setaName(adoption.getaName());

			entity.setAge(adoption.getAge());
			entity.setSpecies(adoption.getSpecies());
			entity.setBreed(adoption.getBreed());
			entity.setAdopterName(adoption.getAdopterName());
			entity.setAdoptDate(adoption.getAdoptDate());
			entity.setAddress(adoption.getAddress());
			entity.setTelnum(adoption.getTelnum());
		}
		
	}

	@Override
	public void deleteAdoptionById(int id) {
		dao.deletebyID(id);

		
	}

	@Override
	public List<Adoption> findAllAdoptions() {
		return dao.findAllAdoptions();
	}

	@Override
	public void saveAdoption(Adoption adoption) {
		// TODO Auto-generated method stub
		dao.save(adoption);

	}

	@Override
	public List<Adoption> findAllAnimals() {
		// TODO Auto-generated method stub
		return dao.findAllAdoptions();
}


}
