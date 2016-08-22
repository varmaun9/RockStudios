package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.OrganisationBranch;
/*
*@Author Sankar
*/
public interface IOrganisationBranchService {
	
	OrganisationBranch create(OrganisationBranch organisationBranch);

	void deleteOrganisationBranch(String organisationBranchId);

	OrganisationBranch getOrganisationBranch(String organisationBranchId);

	List<OrganisationBranch> getAll();

	OrganisationBranch updateOrganisationBranch(OrganisationBranch organisationBranch);
}
