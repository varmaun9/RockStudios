package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.CourseRepository;
import com.rockstudios.domain.Course;
/*
*@Author Sankar
*/
@Component
public class CourseService implements ICourseService{

	@Autowired
	private CourseRepository courseRepository;
	@Override
	public Course create(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(String courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course getCourse(String courseId) {
		// TODO Auto-generated method stub
		 return courseRepository.findOne(courseId);
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
	return courseRepository.save(course);
	}

}
