package com.metacube.EAD_Assignment_8.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_8.model.User;

//User Repository extends Jpa repository which gives methods to perform db operations

@Repository
public interface UserRepo extends JpaRepository<User, Integer> 
{
	
	//query searches for the user whose first name matches
	@Query("SELECT u FROM User u WHERE u.first_name = :first_name")
	List<User> findByfirst_name(@Param("first_name") String first_name);
	
	//query searches for the users whose last name matches
	@Query("SELECT u FROM User u WHERE u.last_name = :last_name")
	List<User> findBylast_name(@Param("last_name") String last_name);
	
	//query searches for the users whose email matches 
	@Query("SELECT u FROM User u WHERE u.email = :email")
	List<User> findByemail(@Param("email") String email);
	
	//query searches for the users whose contact_number matches
	@Query("SELECT u FROM User u WHERE u.contact_number = :contact_number")
	List<User> findBycontact_number(@Param("contact_number") String contact_number);
	
}
