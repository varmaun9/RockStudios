package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "batches", collectionRelation = "batches")
public class BatchesResource extends ResourceWithEmdedded {
	private String batchesId;
	private String batchName;
	private String startTime;
	private String endTime;
	private String status;
	private String description;
	private String createdDate;
	private List<CourseBatchResource> courseBatchResources = new ArrayList<CourseBatchResource>(0);

	public String getBatchesId() {
		return batchesId;
	}

	public void setBatchesId(String batchesId) {
		this.batchesId = batchesId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public List<CourseBatchResource> getCourseBatchResources() {
		return courseBatchResources;
	}

	public void setCourseBatchResources(List<CourseBatchResource> courseBatchResources) {
		this.courseBatchResources = courseBatchResources;
	}

}
