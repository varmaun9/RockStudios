package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.OrganisationBranchRepository;
import com.rockstudios.domain.OrganisationBranch;
/*
*@Author Sankar
*/
@Component
public class OrganisationBranchService implements IOrganisationBranchService{

	@Autowired
	private OrganisationBranchRepository organisationBranchRepository;
	@Override
	public OrganisationBranch create(OrganisationBranch organisationBranch) {
		// TODO Auto-generated method stub
		return organisationBranchRepository.save(organisationBranch);
	}

	@Override
	public void deleteOrganisationBranch(String organisationBranchId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrganisationBranch getOrganisationBranch(String organisationBranchId) {
		// TODO Auto-generated method stub
		 return organisationBranchRepository.findOne(organisationBranchId);
	}

	@Override
	public List<OrganisationBranch> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganisationBranch updateOrganisationBranch(OrganisationBranch organisationBranch) {
		// TODO Auto-generated method stub
	return organisationBranchRepository.save(organisationBranch);
	}

}
