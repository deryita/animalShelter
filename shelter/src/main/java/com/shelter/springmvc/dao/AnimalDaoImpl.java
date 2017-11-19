package com.shelter.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shelter.springmvc.model.Animal;
import com.shelter.springmvc.model.User;

@Repository("animalDao")
public class AnimalDaoImpl extends AbstractDao<Integer, Animal> implements AnimalDao{

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public Animal findById(int id) {
		Animal animal = getByKey(id);
		return animal;
	}

	@Override
	public Animal findByName(String name) {
		logger.info("NAME : {}", name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("aName", name));
		Animal animal = (Animal)crit.uniqueResult();
/*
 * 		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return animal;
	}

	@Override
	public void save(Animal animal) {
		// TODO Auto-generated method stub
		persist(animal);
	}

	@Override
	public void deletebyID(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Animal animal = (Animal)crit.uniqueResult();
		delete(animal);
	}

	@SuppressWarnings("unchecked")
	public List<Animal> findAllAnimals() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("aName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Animal> animals = (List<Animal>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return animals;
	}
}
