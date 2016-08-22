package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Roles;
/*
*@Author Sankar
*/
public interface RolesRepository extends PagingAndSortingRepository<Roles, Serializable>{

}
