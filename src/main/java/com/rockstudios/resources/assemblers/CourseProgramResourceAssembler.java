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

import com.rockstudios.controller.CourseProgramController;
import com.rockstudios.model.CourseProgramModel;
import com.rockstudios.resources.hal.CourseProgramResource;
/*
*@Author Sankar
*/
	@Service
	public class CourseProgramResourceAssembler extends EmbeddableResourceAssemblerSupport<CourseProgramModel, CourseProgramResource, CourseProgramController> {

		 @Autowired
		    public CourseProgramResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, CourseProgramController.class, CourseProgramResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final CourseProgramModel courseProgramModel) {
		        return entityLinks.linkToSingleResource(CourseProgramResource.class, courseProgramModel.getId());
		    }

		    public CourseProgramResource toDetailedResource(final CourseProgramModel entity) {
		        final CourseProgramResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public CourseProgramResource toResource(final CourseProgramModel entity) {
		        final CourseProgramResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setCourseProgramId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
