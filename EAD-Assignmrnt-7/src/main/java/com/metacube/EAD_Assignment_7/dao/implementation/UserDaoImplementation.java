package com.metacube.EAD_Assignment_7.dao.implementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_7.dao.UserDao;
import com.metacube.EAD_Assignment_7.model.User;


/**
 * UserDaoImplementation class implements the interface Userdao which contains some common method to perform some operations
 * @author admin
 *
 */

@Repository
@Transactional
public class UserDaoImplementation implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	//add user to database
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();
		current.save(user);
		return true;
	}

	//delete user from database
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	//update user in database
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
		return false;
	}

	//returns the list of users available in database
	@Override
	public List<User> getAllUser() {
		Session current = sessionFactory.getCurrentSession();	
		CriteriaBuilder builder = current.getCriteriaBuilder();
		CriteriaQuery<User> cQuery =builder.createQuery(User.class);
		Root<User> fromUser = cQuery.from(User.class);
		cQuery.select(fromUser);
		return current.createQuery(cQuery).getResultList();
	}

	//searches the data from user with respect to given type
	@Override
	public List<User> search(String type, String value) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
    	CriteriaQuery<User> cQuery = builder.createQuery(User.class);
    	Root<User> fromUser = cQuery.from(User.class);
    	cQuery.select(fromUser).where(builder.equal(fromUser.get(type), value));
    	return currentSession.createQuery(cQuery).getResultList(); 
	}
	
	
	
}
