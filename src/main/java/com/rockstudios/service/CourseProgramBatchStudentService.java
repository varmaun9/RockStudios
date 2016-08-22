package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.CourseProgramBatchStudentRepository;
import com.rockstudios.domain.CourseProgramBatchStudent;
/*
*@Author Sankar
*/
@Component
public class CourseProgramBatchStudentService implements ICourseProgramBatchStudentService{

	@Autowired
	private CourseProgramBatchStudentRepository courseProgramBatchStudentRepository;
	@Override
	public CourseProgramBatchStudent create(CourseProgramBatchStudent courseProgramBatchStudent) {
		// TODO Auto-generated method stub
		return courseProgramBatchStudentRepository.save(courseProgramBatchStudent);
	}

	@Override
	public void deleteCourseProgramBatchStudent(String courseProgramBatchStudentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CourseProgramBatchStudent getCourseProgramBatchStudent(String courseProgramBatchStudentId) {
		// TODO Auto-generated method stub
		 return courseProgramBatchStudentRepository.findOne(courseProgramBatchStudentId);
	}

	@Override
	public List<CourseProgramBatchStudent> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseProgramBatchStudent updateCourseProgramBatchStudent(CourseProgramBatchStudent courseProgramBatchStudent) {
		// TODO Auto-generated method stub
	return courseProgramBatchStudentRepository.save(courseProgramBatchStudent);
	}

}
