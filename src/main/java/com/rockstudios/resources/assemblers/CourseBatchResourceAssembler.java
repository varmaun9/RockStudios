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

import com.rockstudios.controller.CourseBatchController;
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.resources.hal.CourseBatchResource;

/*
*@Author Sankar
*/
@Service
public class CourseBatchResourceAssembler
		extends EmbeddableResourceAssemblerSupport<CourseBatchModel, CourseBatchResource, CourseBatchController> {
	@Autowired
	private CourseProgramBatchStudentResourceAssembler courseProgramBatchStudentResourceAssembler;

	@Autowired
	public CourseBatchResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		super(entityLinks, relProvider, CourseBatchController.class, CourseBatchResource.class);
	}

	@Override
	public Link linkToSingleResource(final CourseBatchModel courseBatchModel) {
		return entityLinks.linkToSingleResource(CourseBatchResource.class, courseBatchModel.getId());
	}

	public CourseBatchResource toDetailedResource(final CourseBatchModel entity) {
		final CourseBatchResource resource = createResourceWithId(entity.getId(), entity);

		return resource;
	}

	@Override
	public CourseBatchResource toResource(final CourseBatchModel entity) {
		final CourseBatchResource resource = createResourceWithId(entity.getId(), entity);

		BeanUtils.copyProperties(entity, resource);
		resource.setCourseBatchId(entity.getId());

		final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

		if (entity.getCourseProgramBatchStudentModels() != null) {
			embeddables.addAll(courseProgramBatchStudentResourceAssembler
					.toEmbeddable(entity.getCourseProgramBatchStudentModels()));
		}
		resource.setEmbeddeds(new Resources<>(embeddables));
		return resource;
	}
}
