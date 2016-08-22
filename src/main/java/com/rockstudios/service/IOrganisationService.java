package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Organisation;
/*
*@Author Sankar
*/
public interface IOrganisationService {
	
	Organisation create(Organisation organisation);

	void deleteOrganisation(String organisationId);

	Organisation getOrganisation(String organisationId);

	List<Organisation> getAll();

	Organisation updateOrganisation(Organisation organisation);
}
