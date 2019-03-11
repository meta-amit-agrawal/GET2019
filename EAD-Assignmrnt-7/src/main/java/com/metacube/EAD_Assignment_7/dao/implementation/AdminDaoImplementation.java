package com.metacube.EAD_Assignment_7.dao.implementation;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_7.dao.Admindao;
import com.metacube.EAD_Assignment_7.model.Login;

/**
 * AdminDaoImplementation class implements the interface Admindao which contains some common method to perform some operations
 * @author admin
 *
 */

@Repository
@Transactional
public class AdminDaoImplementation implements Admindao 
{
	@Autowired
	SessionFactory sessionFactory;

	//updates the password into the database
	@Override
	public boolean updatePassword(Login login) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(login);	
		return true;
		
	}

	//gets the login details from the database
	@Override
	public Login getLoginbyUserName(String username) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Login.class, username);	
		 
	}
	
}
