package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.CourseBatch;
/*
*@Author Sankar
*/
public interface CourseBatchRepository extends PagingAndSortingRepository<CourseBatch, Serializable>{

}
