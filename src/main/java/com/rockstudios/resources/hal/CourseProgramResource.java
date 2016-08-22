package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "courseProgram", collectionRelation = "courseProgram")
public class CourseProgramResource extends ResourceWithEmdedded {
	private String courseProgramId;
	private String course;
	private String program;
	private String courseProgramName;
	private String status;
	private String createdDate;
	private String duration;
	private String description;
	private List<CourseProgramBatchStudentResource> courseProgramBatchStudentResources = new ArrayList<CourseProgramBatchStudentResource>(
			0);

	public String getCourseProgramId() {
		return courseProgramId;
	}

	public void setCourseProgramId(String courseProgramId) {
		this.courseProgramId = courseProgramId;
	}

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

	public List<CourseProgramBatchStudentResource> getCourseProgramBatchStudentResources() {
		return courseProgramBatchStudentResources;
	}

	public void setCourseProgramBatchStudentResources(
			List<CourseProgramBatchStudentResource> courseProgramBatchStudentResources) {
		this.courseProgramBatchStudentResources = courseProgramBatchStudentResources;
	}

}
