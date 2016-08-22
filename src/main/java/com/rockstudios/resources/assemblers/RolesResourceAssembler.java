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

import com.rockstudios.controller.RolesController;
import com.rockstudios.model.RolesModel;
import com.rockstudios.resources.hal.RolesResource;
/*
*@Author Sankar
*/
	@Service
	public class RolesResourceAssembler extends EmbeddableResourceAssemblerSupport<RolesModel, RolesResource, RolesController> {

		 @Autowired
		    public RolesResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, RolesController.class, RolesResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final RolesModel rolesModel) {
		        return entityLinks.linkToSingleResource(RolesResource.class, rolesModel.getId());
		    }

		    public RolesResource toDetailedResource(final RolesModel entity) {
		        final RolesResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public RolesResource toResource(final RolesModel entity) {
		        final RolesResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setRolesId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
