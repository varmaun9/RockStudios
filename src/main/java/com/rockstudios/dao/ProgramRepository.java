package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Program;
/*
*@Author Sankar
*/
public interface ProgramRepository extends PagingAndSortingRepository<Program, Serializable>{

}
