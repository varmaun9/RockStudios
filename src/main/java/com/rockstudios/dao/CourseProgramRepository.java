package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.CourseProgram;
/*
*@Author Sankar
*/
public interface CourseProgramRepository extends PagingAndSortingRepository<CourseProgram, Serializable>{

}
