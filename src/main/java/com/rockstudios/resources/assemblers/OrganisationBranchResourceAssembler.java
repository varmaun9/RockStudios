package com.rockstudios.resources.assemblers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Service;

import com.rockstudios.controller.OrganisationBranchController;
import com.rockstudios.model.OrganisationBranchModel;
import com.rockstudios.resources.hal.OrganisationBranchResource;
/*
*@Author Sankar
*/
	@Service
	public class OrganisationBranchResourceAssembler extends EmbeddableResourceAssemblerSupport<OrganisationBranchModel, OrganisationBranchResource, OrganisationBranchController> {

		 @Autowired
		    public OrganisationBranchResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, OrganisationBranchController.class, OrganisationBranchResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final OrganisationBranchModel organisationBranchModel) {
		        return entityLinks.linkToSingleResource(OrganisationBranchResource.class, organisationBranchModel.getId());
		    }

		    public OrganisationBranchResource toDetailedResource(final OrganisationBranchModel entity) {
		        final OrganisationBranchResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public OrganisationBranchResource toResource(final OrganisationBranchModel entity) {
		        final OrganisationBranchResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setOrganisationBranchId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
