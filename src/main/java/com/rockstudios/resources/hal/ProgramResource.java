package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "program", collectionRelation = "program")
public class ProgramResource extends ResourceWithEmdedded {
	private String programId;
	private String programName;
	private String duration;
	private String status;
	private String description;
	private List<CourseProgramResource> courseProgramResources = new ArrayList<CourseProgramResource>(0);

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

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

	public List<CourseProgramResource> getCourseProgramResources() {
		return courseProgramResources;
	}

	public void setCourseProgramResources(List<CourseProgramResource> courseProgramResources) {
		this.courseProgramResources = courseProgramResources;
	}

}
