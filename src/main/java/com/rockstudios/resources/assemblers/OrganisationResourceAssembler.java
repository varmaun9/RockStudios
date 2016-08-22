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

import com.rockstudios.controller.OrganisationController;
import com.rockstudios.model.OrganisationModel;
import com.rockstudios.resources.hal.OrganisationResource;
/*
*@Author Sankar
*/
	@Service
	public class OrganisationResourceAssembler extends EmbeddableResourceAssemblerSupport<OrganisationModel, OrganisationResource, OrganisationController> {

		 @Autowired
		    public OrganisationResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, OrganisationController.class, OrganisationResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final OrganisationModel organisationModel) {
		        return entityLinks.linkToSingleResource(OrganisationResource.class, organisationModel.getId());
		    }

		    public OrganisationResource toDetailedResource(final OrganisationModel entity) {
		        final OrganisationResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public OrganisationResource toResource(final OrganisationModel entity) {
		        final OrganisationResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setOrganisationId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
