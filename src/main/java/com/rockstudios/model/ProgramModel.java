package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("programModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProgramModel extends AbstractModel {

	private String programName;
	private String duration;
	private String status;
	private String description;
	private List<CourseProgramModel> courseProgramModels = new ArrayList<CourseProgramModel>(0);

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CourseProgramModel> getCourseProgramModels() {
		return courseProgramModels;
	}

	public void setCourseProgramModels(List<CourseProgramModel> courseProgramModels) {
		this.courseProgramModels = courseProgramModels;
	}

}
