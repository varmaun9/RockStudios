package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.CourseProgram;

public interface ICourseProgramService {

	CourseProgram create(CourseProgram courseProgram);

	void deleteCourseProgram(String courseProgramId);

	CourseProgram getCourseProgram(String courseProgramId);

	List<CourseProgram> getAll();

	CourseProgram updateCourseProgram(CourseProgram courseProgram);
}
