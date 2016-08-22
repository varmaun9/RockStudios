package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.CourseProgramRepository;
import com.rockstudios.domain.CourseProgram;
/*
*@Author Sankar
*/
@Component
public class CourseProgramService implements ICourseProgramService{

	@Autowired
	private CourseProgramRepository courseProgramRepository;
	@Override
	public CourseProgram create(CourseProgram courseProgram) {
		// TODO Auto-generated method stub
		return courseProgramRepository.save(courseProgram);
	}

	@Override
	public void deleteCourseProgram(String courseProgramId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CourseProgram getCourseProgram(String courseProgramId) {
		// TODO Auto-generated method stub
		 return courseProgramRepository.findOne(courseProgramId);
	}

	@Override
	public List<CourseProgram> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseProgram updateCourseProgram(CourseProgram courseProgram) {
		// TODO Auto-generated method stub
	return courseProgramRepository.save(courseProgram);
	}

}
