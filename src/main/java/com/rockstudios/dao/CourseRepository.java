package com.rockstudios.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.Course;
/*
*@Author Sankar
*/
public interface CourseRepository extends PagingAndSortingRepository<Course, Serializable>{

}
