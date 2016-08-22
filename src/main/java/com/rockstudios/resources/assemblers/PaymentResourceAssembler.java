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

import com.rockstudios.controller.PaymentController;
import com.rockstudios.model.PaymentModel;
import com.rockstudios.resources.hal.PaymentResource;
/*
*@Author Sankar
*/
	@Service
	public class PaymentResourceAssembler extends EmbeddableResourceAssemblerSupport<PaymentModel, PaymentResource, PaymentController> {

		 @Autowired
		    public PaymentResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		        super(entityLinks, relProvider, PaymentController.class, PaymentResource.class);
		    }

		    @Override
		    public Link linkToSingleResource(final PaymentModel paymentModel) {
		        return entityLinks.linkToSingleResource(PaymentResource.class, paymentModel.getId());
		    }

		    public PaymentResource toDetailedResource(final PaymentModel entity) {
		        final PaymentResource resource = createResourceWithId(entity.getId(), entity);

		        return resource;
		    }

		    @Override
		    public PaymentResource toResource(final PaymentModel entity) {
		        final PaymentResource resource = createResourceWithId(entity.getId(), entity);

		        BeanUtils.copyProperties(entity, resource);
		        resource.setPaymentId(entity.getId());

		        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
		      

		        resource.setEmbeddeds(new Resources<>(embeddables));
		        return resource;
		    }
}
