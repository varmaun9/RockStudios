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

import com.rockstudios.controller.CourseController;
import com.rockstudios.model.CourseModel;
import com.rockstudios.resources.hal.CourseResource;
/*
*@Author Sankar
*/
	@Service
	public class CourseResourceAssembler extends EmbeddableResourceAssemblerSupport<CourseModel, CourseResource, CourseController> {

		 @Autowired
		    public CourseResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, CourseController.class, CourseResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final CourseModel courseModel) {
		        return entityLinks.linkToSingleResource(CourseResource.class, courseModel.getId());
		    }

		    public CourseResource toDetailedResource(final CourseModel entity) {
		        final CourseResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public CourseResource toResource(final CourseModel entity) {
		        final CourseResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setCourseId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
