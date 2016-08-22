package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Users;
/*
*@Author Sankar
*/
public interface UsersRepository extends PagingAndSortingRepository<Users, Serializable>{

}
