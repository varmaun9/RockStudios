package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("courseModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseModel extends AbstractModel {

	private String organisationBranchId;
	private String courseName;
	private String status;
	private String description;
	private String createdDate;
	private String courseCode;
	private List<CourseBatchModel> courseBatchModels = new ArrayList<CourseBatchModel>(0);
	private List<CourseProgramModel> courseProgramModels = new ArrayList<CourseProgramModel>(0);

	public String getOrganisationBranchId() {
		return organisationBranchId;
	}

	public void setOrganisationBranchId(String organisationBranchId) {
		this.organisationBranchId = organisationBranchId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public List<CourseBatchModel> getCourseBatchModels() {
		return courseBatchModels;
	}

	public void setCourseBatchModels(List<CourseBatchModel> courseBatchModels) {
		this.courseBatchModels = courseBatchModels;
	}

	public List<CourseProgramModel> getCourseProgramModels() {
		return courseProgramModels;
	}

	public void setCourseProgramModels(List<CourseProgramModel> courseProgramModels) {
		this.courseProgramModels = courseProgramModels;
	}

}
