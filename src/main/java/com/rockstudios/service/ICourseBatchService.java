package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.CourseBatch;
/*
*@Author Sankar
*/
public interface ICourseBatchService {
	
	CourseBatch create(CourseBatch courseBatch);

	void deleteCourseBatch(String courseBatchId);

	CourseBatch getCourseBatch(String courseBatchId);

	List<CourseBatch> getAll();

	CourseBatch updateCourseBatch(CourseBatch courseBatch);
}
