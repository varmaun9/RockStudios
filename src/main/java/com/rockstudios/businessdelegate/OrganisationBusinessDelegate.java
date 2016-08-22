package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.OrganisationContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Organisation;
import com.rockstudios.model.OrganisationModel;
import com.rockstudios.service.OrganisationService;

/*
*@Author Sankar
*/

@Service
public class OrganisationBusinessDelegate
		implements IBusinessDelegate<OrganisationModel, OrganisationContext, IKeyBuilder<String>, String> {

	@Autowired
	private OrganisationService organisationService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public OrganisationModel create(OrganisationModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, OrganisationContext context) {

	}

	@Override
	public OrganisationModel edit(IKeyBuilder<String> keyBuilder, OrganisationModel model) {
		Organisation organisation = organisationService.getOrganisation(keyBuilder.build().toString());
		
		organisation = organisationService.updateOrganisation(organisation);
		
		return model;
	}

	@Override
	public OrganisationModel getByKey(IKeyBuilder<String> keyBuilder, OrganisationContext context) {
		Organisation organisation = organisationService.getOrganisation(keyBuilder.build().toString());
		OrganisationModel model = conversionService.convert(organisation, OrganisationModel.class);
		return model;
	}

	@Override
	public Collection<OrganisationModel> getCollection(OrganisationContext context) {
		List<Organisation> organisation = new ArrayList<Organisation>();
		if (context.getAll() != null) {
			organisation = organisationService.getAll();
		}
		List<OrganisationModel> organisationModels = (List<OrganisationModel>) conversionService.convert(
				organisation, TypeDescriptor.forObject(organisation),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(OrganisationModel.class)));
		return organisationModels;
	}

}
