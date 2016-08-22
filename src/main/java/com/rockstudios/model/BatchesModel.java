package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("batchesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BatchesModel extends AbstractModel {
	
	private String batchName;
	private String startTime;
	private String endTime;
	private String status;
	private String description;
	private String createdDate;
	private List<CourseBatchModel> courseBatchModels = new ArrayList<CourseBatchModel>(0);
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
	public List<CourseBatchModel> getCourseBatchModels() {
		return courseBatchModels;
	}
	public void setCourseBatchModels(List<CourseBatchModel> courseBatchModels) {
		this.courseBatchModels = courseBatchModels;
	}
	
}
