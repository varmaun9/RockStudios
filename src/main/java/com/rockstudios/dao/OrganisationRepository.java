package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Organisation;
/*
*@Author Sankar
*/
public interface OrganisationRepository extends PagingAndSortingRepository<Organisation, Serializable>{

}
