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

import com.rockstudios.controller.CourseProgramBatchStudentController;
import com.rockstudios.model.CourseProgramBatchStudentModel;
import com.rockstudios.resources.hal.CourseProgramBatchStudentResource;
/*
*@Author Sankar
*/
	@Service
	public class CourseProgramBatchStudentResourceAssembler extends EmbeddableResourceAssemblerSupport<CourseProgramBatchStudentModel, CourseProgramBatchStudentResource, CourseProgramBatchStudentController> {

		 @Autowired
		    public CourseProgramBatchStudentResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, CourseProgramBatchStudentController.class, CourseProgramBatchStudentResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final CourseProgramBatchStudentModel courseProgramBatchStudentModel) {
		        return entityLinks.linkToSingleResource(CourseProgramBatchStudentResource.class, courseProgramBatchStudentModel.getId());
		    }

		    public CourseProgramBatchStudentResource toDetailedResource(final CourseProgramBatchStudentModel entity) {
		        final CourseProgramBatchStudentResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public CourseProgramBatchStudentResource toResource(final CourseProgramBatchStudentModel entity) {
		        final CourseProgramBatchStudentResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setCourseProgramBatchStudentId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
