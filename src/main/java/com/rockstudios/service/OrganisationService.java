package com.rockstudios.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.OrganisationRepository;
import com.rockstudios.domain.Organisation;
import com.rockstudios.domain.OrganisationBranch;
/*
*@Author Sankar
*/
@Component
public class OrganisationService implements IOrganisationService{

	@Autowired
	private OrganisationRepository organisationRepository;
	
	@Autowired
	private IOrganisationBranchService organisationBranchService;
	@Override
	@Transactional
	public Organisation create(Organisation organisation) {
		organisation.setCreatedDate(new Date());
		organisation.setStatus("ACTIVE");
		organisation = organisationRepository.save(organisation);
		if(organisation.getOrganisationBranches()!=null){
			for(OrganisationBranch organisationBranch : organisation.getOrganisationBranches()){
				OrganisationBranch organisationBrnch = organisationBranch;
				organisationBrnch.setOrganisation(organisation);
				organisationBrnch = organisationBranchService.create(organisationBrnch);
			}
		}
		return organisation;
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
