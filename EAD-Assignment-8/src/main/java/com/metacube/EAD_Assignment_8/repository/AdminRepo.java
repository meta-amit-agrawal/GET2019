package com.metacube.EAD_Assignment_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_8.model.Login;

//Admin Repository extends Jpa repository which gives methods to perform db operations

@Repository
public interface AdminRepo extends JpaRepository<Login, String> 
{

}
