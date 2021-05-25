package com.larissa.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.larissa.models.Person;

@Repository
@Transactional
public class PersonRepo {
	
	@Autowired
	private SessionFactory factory;
	
	public void savePerson(Person person) {
	getSession().save(person);
	}
	
	public List<Person> getPersons(){
		return getSession().createCriteria(Person.class).list();
	}
	
	private Session getSession() {
		Session session=factory.getCurrentSession();
		if(session==null) {
			session=factory.openSession();
		}
		return session;
	}

}
