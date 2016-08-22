package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "organisationBranch", collectionRelation = "organisationBranch")
public class OrganisationBranchResource extends ResourceWithEmdedded {
	private String organisationBranchId;
	private String organisationId;
	private String branchName;
	private String branchEmailId;
	private String branchPhoneNo;
	private String branchAlternativePhoneNo;
	private String status;
	private String createdDate;
	private String branchCode;
	private List<CourseResource> courseResources = new ArrayList<CourseResource>(0);

	public String getOrganisationBranchId() {
		return organisationBranchId;
	}

	public void setOrganisationBranchId(String organisationBranchId) {
		this.organisationBranchId = organisationBranchId;
	}

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

	public List<CourseResource> getCourseResources() {
		return courseResources;
	}

	public void setCourseResources(List<CourseResource> courseResources) {
		this.courseResources = courseResources;
	}

}
