package com.rockstudios.resources.hal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.core.Relation;

@Relation(value = "organisation", collectionRelation = "organisation")
public class OrganisationResource extends ResourceWithEmdedded {
	private String organisationId;
	private String organisationName;
	private String status;
	private String createdDate;
	private List<OrganisationBranchResource> organisationBranchResources = new ArrayList<OrganisationBranchResource>(0);

	public String getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
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

	public List<OrganisationBranchResource> getOrganisationBranchResources() {
		return organisationBranchResources;
	}

	public void setOrganisationBranchResources(List<OrganisationBranchResource> organisationBranchResources) {
		this.organisationBranchResources = organisationBranchResources;
	}

}
