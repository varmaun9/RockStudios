package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("organisationBranchModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrganisationBranchModel extends AbstractModel {

	private String organisationId;
	private String branchName;
	private String branchEmailId;
	private String branchPhoneNo;
	private String branchAlternativePhoneNo;
	private String status;
	private String createdDate;
	private String branchCode;
	private List<CourseModel> courseModels = new ArrayList<CourseModel>(0);

	public String getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchEmailId() {
		return branchEmailId;
	}

	public void setBranchEmailId(String branchEmailId) {
		this.branchEmailId = branchEmailId;
	}

	public String getBranchPhoneNo() {
		return branchPhoneNo;
	}

	public void setBranchPhoneNo(String branchPhoneNo) {
		this.branchPhoneNo = branchPhoneNo;
	}

	public String getBranchAlternativePhoneNo() {
		return branchAlternativePhoneNo;
	}

	public void setBranchAlternativePhoneNo(String branchAlternativePhoneNo) {
		this.branchAlternativePhoneNo = branchAlternativePhoneNo;
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

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public List<CourseModel> getCourseModels() {
		return courseModels;
	}

	public void setCourseModels(List<CourseModel> courseModels) {
		this.courseModels = courseModels;
	}

}
