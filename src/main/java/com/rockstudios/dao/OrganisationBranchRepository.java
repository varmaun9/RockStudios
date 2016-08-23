package com.rockstudios.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rockstudios.domain.OrganisationBranch;
/*
*@Author Sankar
*/
public interface OrganisationBranchRepository extends PagingAndSortingRepository<OrganisationBranch, String>, JpaSpecificationExecutor<OrganisationBranch> {
	 
	@Query("select MAX(branchCount) from OrganisationBranch")
	Integer getMaxCode();

}
