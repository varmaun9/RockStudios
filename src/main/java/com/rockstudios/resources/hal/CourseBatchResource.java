package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "courseBatch", collectionRelation = "courseBatch")
public class CourseBatchResource extends ResourceWithEmdedded {
	private String courseBatchId;
	private String courseId;
	private String batchesId;
	private String status;
	private String description;
	private List<CourseProgramBatchStudentResource> courseProgramBatchStudentResources = new ArrayList<CourseProgramBatchStudentResource>(
			0);

	public String getCourseBatchId() {
		return courseBatchId;
	}

	public void setCourseBatchId(String courseBatchId) {
		this.courseBatchId = courseBatchId;
	}

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

	public List<CourseProgramBatchStudentResource> getCourseProgramBatchStudentResources() {
		return courseProgramBatchStudentResources;
	}

	public void setCourseProgramBatchStudentResources(
			List<CourseProgramBatchStudentResource> courseProgramBatchStudentResources) {
		this.courseProgramBatchStudentResources = courseProgramBatchStudentResources;
	}

}
