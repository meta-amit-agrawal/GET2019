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
import com.metacube.EAD_Assignment_7.model.Login;
import com.metacube.EAD_Assignment_7.model.User;

@Repository
@Transactional
public class UserDaoImplementation implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();
		try{
			current.save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();	
		CriteriaBuilder builder = current.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery =builder.createQuery(User.class);
		Root<User> userRoot = criteriaQuery.from(User.class);
		criteriaQuery.select(userRoot);
		return current.createQuery(criteriaQuery).getResultList();
	}

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
