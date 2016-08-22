package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Course;
/*
*@Author Sankar
*/
public interface ICourseService {
	
	Course create(Course course);

	void deleteCourse(String courseId);

	Course getCourse(String courseId);

	List<Course> getAll();

	Course updateCourse(Course course);
}
