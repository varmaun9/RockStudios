package com.rockstudios.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.DBSequences;
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
	@Transactional
	public OrganisationBranch create(OrganisationBranch organisationBranch) {
	
		 Integer i = organisationBranchRepository.getMaxCode();
        if (i == null || i == 0) {
            i = 0;
            organisationBranch.setBranchCount(i + 1);
        }
        else {
        	organisationBranch.setBranchCount(i + 1);
        }
        Integer co = i + 1;
        String m = DBSequences.ORGANISATIONBRANCH.getSequenceName();
        String mc = m.concat(co.toString());
        organisationBranch.setBranchCode(mc);
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
