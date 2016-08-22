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

import com.rockstudios.controller.ProgramController;
import com.rockstudios.model.ProgramModel;
import com.rockstudios.resources.hal.ProgramResource;
/*
*@Author Sankar
*/
	@Service
	public class ProgramResourceAssembler extends EmbeddableResourceAssemblerSupport<ProgramModel, ProgramResource, ProgramController> {

		 @Autowired
		    public ProgramResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, ProgramController.class, ProgramResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final ProgramModel programModel) {
		        return entityLinks.linkToSingleResource(ProgramResource.class, programModel.getId());
		    }

		    public ProgramResource toDetailedResource(final ProgramModel entity) {
		        final ProgramResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public ProgramResource toResource(final ProgramModel entity) {
		        final ProgramResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setProgramId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
