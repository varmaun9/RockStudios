package com.rockstudios.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
*@Author Sankar
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrganisationBranchContext implements IBusinessDelegateContext {

	private String all;
	private String organisationBranchId;

	
	
	public String getOrganisationBranchId() {
		return organisationBranchId;
	}

	public void setOrganisationBranchId(String organisationBranchId) {
		this.organisationBranchId = organisationBranchId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
