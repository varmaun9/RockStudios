package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.OrganisationRepository;
import com.rockstudios.domain.Organisation;
/*
*@Author Sankar
*/
@Component
public class OrganisationService implements IOrganisationService{

	@Autowired
	private OrganisationRepository organisationRepository;
	@Override
	public Organisation create(Organisation organisation) {
		// TODO Auto-generated method stub
		return organisationRepository.save(organisation);
	}

	@Override
	public void deleteOrganisation(String organisationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Organisation getOrganisation(String organisationId) {
		// TODO Auto-generated method stub
		 return organisationRepository.findOne(organisationId);
	}

	@Override
	public List<Organisation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organisation updateOrganisation(Organisation organisation) {
		// TODO Auto-generated method stub
	return organisationRepository.save(organisation);
	}

}
