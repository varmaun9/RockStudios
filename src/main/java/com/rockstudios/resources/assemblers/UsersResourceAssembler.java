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

import com.rockstudios.controller.UsersController;
import com.rockstudios.model.UsersModel;
import com.rockstudios.resources.hal.UsersResource;
/*
*@Author Sankar
*/
	@Service
	public class UsersResourceAssembler extends EmbeddableResourceAssemblerSupport<UsersModel, UsersResource, UsersController> {

		 @Autowired
		    public UsersResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, UsersController.class, UsersResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final UsersModel usersModel) {
		        return entityLinks.linkToSingleResource(UsersResource.class, usersModel.getId());
		    }

		    public UsersResource toDetailedResource(final UsersModel entity) {
		        final UsersResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public UsersResource toResource(final UsersModel entity) {
		        final UsersResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setUsersId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
