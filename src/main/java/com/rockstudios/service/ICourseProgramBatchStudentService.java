package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.CourseProgramBatchStudent;
/*
*@Author Sankar
*/
public interface ICourseProgramBatchStudentService {
	
	CourseProgramBatchStudent create(CourseProgramBatchStudent courseProgramBatchStudent);

	void deleteCourseProgramBatchStudent(String courseProgramBatchStudentId);

	CourseProgramBatchStudent getCourseProgramBatchStudent(String courseProgramBatchStudentId);

	List<CourseProgramBatchStudent> getAll();

	CourseProgramBatchStudent updateCourseProgramBatchStudent(CourseProgramBatchStudent courseProgramBatchStudent);
}
