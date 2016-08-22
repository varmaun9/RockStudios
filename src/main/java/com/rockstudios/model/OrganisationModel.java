package com.rockstudios.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("organisationModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrganisationModel extends AbstractModel {

	private String organisationName;
	private String status;
	private String createdDate;
	private List<OrganisationBranchModel> organisationBranchModel = new ArrayList<OrganisationBranchModel>(0);

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

	public List<OrganisationBranchModel> getOrganisationBranchModel() {
		return organisationBranchModel;
	}

	public void setOrganisationBranchModel(List<OrganisationBranchModel> organisationBranchModel) {
		this.organisationBranchModel = organisationBranchModel;
	}

}
