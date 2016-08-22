package com.rockstudios.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
*@Author Sankar
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseProgramBatchStudentContext implements IBusinessDelegateContext {

	private String all;
	private String courseProgramBatchStudentId;

	
	
	public String getCourseProgramBatchStudentId() {
		return courseProgramBatchStudentId;
	}

	public void setCourseProgramBatchStudentId(String courseProgramBatchStudentId) {
		this.courseProgramBatchStudentId = courseProgramBatchStudentId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
