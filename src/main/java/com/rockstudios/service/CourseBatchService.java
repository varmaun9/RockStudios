package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.CourseBatchRepository;
import com.rockstudios.domain.CourseBatch;
/*
*@Author Sankar
*/
@Component
public class CourseBatchService implements ICourseBatchService{

	@Autowired
	private CourseBatchRepository courseBatchRepository;
	@Override
	public CourseBatch create(CourseBatch courseBatch) {
		return courseBatchRepository.save(courseBatch);
	}

	@Override
	public void deleteCourseBatch(String courseBatchId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CourseBatch getCourseBatch(String courseBatchId) {
		// TODO Auto-generated method stub
		 return courseBatchRepository.findOne(courseBatchId);
	}

	@Override
	public List<CourseBatch> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseBatch updateCourseBatch(CourseBatch courseBatch) {
		// TODO Auto-generated method stub
	return courseBatchRepository.save(courseBatch);
	}

}
