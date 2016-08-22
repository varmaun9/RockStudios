package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.OrganisationBranchContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.OrganisationBranch;
import com.rockstudios.model.OrganisationBranchModel;
import com.rockstudios.service.OrganisationBranchService;

/*
*@Author Sankar
*/

@Service
public class OrganisationBranchBusinessDelegate
		implements IBusinessDelegate<OrganisationBranchModel, OrganisationBranchContext, IKeyBuilder<String>, String> {

	@Autowired
	private OrganisationBranchService organisationBranchService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public OrganisationBranchModel create(OrganisationBranchModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, OrganisationBranchContext context) {

	}

	@Override
	public OrganisationBranchModel edit(IKeyBuilder<String> keyBuilder, OrganisationBranchModel model) {
		OrganisationBranch organisationBranch = organisationBranchService.getOrganisationBranch(keyBuilder.build().toString());
		
		organisationBranch = organisationBranchService.updateOrganisationBranch(organisationBranch);
		
		return model;
	}

	@Override
	public OrganisationBranchModel getByKey(IKeyBuilder<String> keyBuilder, OrganisationBranchContext context) {
		OrganisationBranch organisationBranch = organisationBranchService.getOrganisationBranch(keyBuilder.build().toString());
		OrganisationBranchModel model = conversionService.convert(organisationBranch, OrganisationBranchModel.class);
		return model;
	}

	@Override
	public Collection<OrganisationBranchModel> getCollection(OrganisationBranchContext context) {
		List<OrganisationBranch> organisationBranch = new ArrayList<OrganisationBranch>();
		if (context.getAll() != null) {
			organisationBranch = organisationBranchService.getAll();
		}
		List<OrganisationBranchModel> organisationBranchModels = (List<OrganisationBranchModel>) conversionService.convert(
				organisationBranch, TypeDescriptor.forObject(organisationBranch),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(OrganisationBranchModel.class)));
		return organisationBranchModels;
	}

}
