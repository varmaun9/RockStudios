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

import com.rockstudios.controller.BatchesController;
import com.rockstudios.model.BatchesModel;
import com.rockstudios.resources.hal.BatchesResource;
/*
*@Author Sankar
*/
	@Service
	public class BatchesResourceAssembler extends EmbeddableResourceAssemblerSupport<BatchesModel, BatchesResource, BatchesController> {

		 @Autowired
		    public BatchesResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, BatchesController.class, BatchesResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final BatchesModel batchesModel) {
		        return entityLinks.linkToSingleResource(BatchesResource.class, batchesModel.getId());
		    }

		    public BatchesResource toDetailedResource(final BatchesModel entity) {
		        final BatchesResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public BatchesResource toResource(final BatchesModel entity) {
		        final BatchesResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setBatchesId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
