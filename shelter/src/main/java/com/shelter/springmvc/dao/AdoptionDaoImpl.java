package com.shelter.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shelter.springmvc.model.Adoption;

@Repository("adoptionDao")
public class AdoptionDaoImpl extends AbstractDao<Integer, Adoption> implements AdoptionDao{

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public Adoption findById(int id) {
		Adoption adoption = getByKey(id);
		return adoption;
	}

	@Override
	public Adoption findByAnimalName(String name) {
		logger.info("NAME : {}", name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("aName", name));
		Adoption animal = (Adoption)crit.uniqueResult();
/*
 * 		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return animal;
	}
	
	@Override
	public Adoption findByAdopterName(String name) {
		logger.info("NAME : {}", name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("adopterName", name));
		Adoption animal = (Adoption)crit.uniqueResult();
/*
 * 		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return animal;
	}

	@Override
	public void save(Adoption adoption) {
		// TODO Auto-generated method stub
		persist(adoption);
	}

	@Override
	public void deletebyID(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Adoption adoption = (Adoption)crit.uniqueResult();
		delete(adoption);
	}

	@SuppressWarnings("unchecked")
	public List<Adoption> findAllAnimals() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("aName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Adoption> adoption = (List<Adoption>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return adoption;
	}

	@SuppressWarnings("unchecked")
	public List<Adoption> findAllAdoptions() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("adopterName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Adoption> adoption = (List<Adoption>) criteria.list();
		return adoption;
	}
}
