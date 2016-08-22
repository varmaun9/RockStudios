package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "course", collectionRelation = "course")
public class CourseResource extends ResourceWithEmdedded {
	private String courseId;
	private String organisationBranchId;
	private String courseName;
	private String status;
	private String description;
	private String createdDate;
	private String courseCode;
	private List<CourseBatchResource> courseBatchResources = new ArrayList<CourseBatchResource>(0);
	private List<CourseProgramResource> courseProgramResources = new ArrayList<CourseProgramResource>(0);

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

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

	public List<CourseBatchResource> getCourseBatchResources() {
		return courseBatchResources;
	}

	public void setCourseBatchResources(List<CourseBatchResource> courseBatchResources) {
		this.courseBatchResources = courseBatchResources;
	}

	public List<CourseProgramResource> getCourseProgramResources() {
		return courseProgramResources;
	}

	public void setCourseProgramResources(List<CourseProgramResource> courseProgramResources) {
		this.courseProgramResources = courseProgramResources;
	}

}
