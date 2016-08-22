package com.rockstudios.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
*@Author Sankar
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseProgramContext implements IBusinessDelegateContext {

	private String all;
	private String courseProgramId;

	
	
	public String getCourseProgramId() {
		return courseProgramId;
	}

	public void setCourseProgramId(String courseProgramId) {
		this.courseProgramId = courseProgramId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
