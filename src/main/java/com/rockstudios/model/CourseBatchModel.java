package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("courseBatchModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CourseBatchModel extends AbstractModel {

	private String courseId;
	private String batchesId;
	private String status;
	private String description;
	private List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels = new ArrayList<CourseProgramBatchStudentModel>(
			0);

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getBatchesId() {
		return batchesId;
	}

	public void setBatchesId(String batchesId) {
		this.batchesId = batchesId;
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

	public List<CourseProgramBatchStudentModel> getCourseProgramBatchStudentModels() {
		return courseProgramBatchStudentModels;
	}

	public void setCourseProgramBatchStudentModels(
			List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels) {
		this.courseProgramBatchStudentModels = courseProgramBatchStudentModels;
	}

}
