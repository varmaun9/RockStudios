package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Users;
/*
*@Author Sankar
*/
public interface UsersRepository extends PagingAndSortingRepository<Users, Serializable>{

	@Query("SELECT DISTINCT u FROM Users u where u.emailId=?1")
	Users findByEmailId(String email);
	@Query("SELECT DISTINCT u FROM Users u where u.phoneNo=?1")
	Users findByPhoneNo(String phoneNo);
	/**
     * @return
     */
    @Query("SELECT MAX(usersCount) FROM Users u")
    Integer getMaxCode();

}
