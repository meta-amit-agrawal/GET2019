package com.metacube.EAD_Assignment_7.dao.implementation;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_7.dao.Admindao;
import com.metacube.EAD_Assignment_7.model.Login;


@Repository
@Transactional
public class AdminDaoImplementation implements Admindao 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean updatePassword(Login login) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(login);	
		return true;
		
	}

	@Override
	public Login getLoginbyUserName(String username) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Login.class, username);	
		 
	}
	
}
/*Session current = sessionFactory.getCurrentSession();	
CriteriaBuilder builder = current.getCriteriaBuilder();
CriteriaQuery<DBUser> criteriaQuery =builder.createQuery(DBUser.class);
Root<DBUser> userRoot = criteriaQuery.from(DBUser.class);
criteriaQuery.select(userRoot).where(builder.equal(userRoot.get("username"),u.getUsername()));
try{
	return current.createQuery(criteriaQuery).getSingleResult();
}catch(Exception e){
 System.out.println(e.getMessage());
}
return user;
}*/