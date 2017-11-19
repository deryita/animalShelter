package com.shelter.springmvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shelter.springmvc.dao.AnimalDao;
import com.shelter.springmvc.dao.UserDao;
import com.shelter.springmvc.model.Animal;
import com.shelter.springmvc.model.User;

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalDao dao;

	@Override
	public Animal findById(int id) {
		return dao.findById(id);

	}

	@Override
	public Animal findByName(String name) {
		Animal animal = dao.findByName(name);
		return animal;
	}

	/*tryme*/
	@Override
	public List<Animal> searchAnimal(String chars){
		List<Animal> returnList = new ArrayList<Animal>();
		for (Animal next : findAllAnimals()){
			if(next.getaName().toUpperCase().contains(chars.toUpperCase())) {
				returnList.add(next);
			}
		}
		Collections.sort(returnList, new Comparator<Animal>() {
			@Override
			public int compare(Animal a1, Animal a2) {
				return a1.getaName().compareTo(a2.getaName());
			}
		});
		return returnList;
	}
	
/*
 * create table animal (
   id BIGINT NOT NULL AUTO_INCREMENT,
   aName VARCHAR(30) NOT NULL,
   age VARCHAR(2) NOT NULL,
   species VARCHAR(30) NOT NULL,
   breed  VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);*/

	@Override
	public void updateAnimal(Animal animal) {
		Animal entity = dao.findById(animal.getId());
		if(entity!=null){
			entity.setaName(animal.getaName());

			entity.setAge(animal.getAge());
			entity.setSpecies(animal.getSpecies());
			entity.setBreed(animal.getBreed());
		}
		
	}

	@Override
	public void deleteAnimalById(int id) {
		dao.deletebyID(id);

		
	}

	@Override
	public List<Animal> findAllAnimals() {
		return dao.findAllAnimals();
	}

	@Override
	public void saveAnimal(Animal animal) {
		// TODO Auto-generated method stub
		dao.save(animal);

	}

}
