package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("courseProgramModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseProgramModel extends AbstractModel {

	private String course;
	private String program;
	private String courseProgramName;
	private String status;
	private String createdDate;
	private String duration;
	private String description;
	private List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels = new ArrayList<CourseProgramBatchStudentModel>(
			0);

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getCourseProgramName() {
		return courseProgramName;
	}

	public void setCourseProgramName(String courseProgramName) {
		this.courseProgramName = courseProgramName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CourseProgramBatchStudentModel> getCourseProgramBatchStudentModels() {
		return courseProgramBatchStudentModels;
	}

	public void setCourseProgramBatchStudentModels(
			List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels) {
		this.courseProgramBatchStudentModels = courseProgramBatchStudentModels;
	}

}
