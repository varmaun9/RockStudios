package com.rockstudios.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rockstudios.businessdelegate.IBusinessDelegate;
import com.rockstudios.businessdelegate.context.BatchesContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.BatchesModel;
import com.rockstudios.resources.assemblers.BatchesResourceAssembler;
import com.rockstudios.resources.hal.BatchesResource;
	
	@RestController
	@ExposesResourceFor(value = BatchesResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/batches", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class BatchesController {
	    private static final Logger LOGGER = Logger.getLogger(BatchesController.class);

	    private IBusinessDelegate<BatchesModel, BatchesContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<BatchesContext> batchesContextFactory;

	    @Autowired
	    private BatchesResourceAssembler batchesResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<BatchesResource> createBatches(@RequestBody final BatchesModel batchesModel) {
	    	
	    	BatchesModel model = businessDelegate.create(batchesModel);
	    	BatchesResource resource = batchesResourceAssembler.toResource(model);

	        return new ResponseEntity<BatchesResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteBatches(@PathVariable(value = "id") final String batchesId) {

	    	BatchesContext batchesContext = batchesContextFactory.getObject();
	    	batchesContext.setBatchesId(batchesId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(batchesId), batchesContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<BatchesResource> edit(@PathVariable(value = "id") final String batchesId,
	            @RequestBody final BatchesModel batchesModel) {
	    	BatchesModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(batchesId), batchesModel);
	    	BatchesResource resource =  batchesResourceAssembler.toResource(model);
	        return new ResponseEntity<BatchesResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<BatchesResource> getBatches(@PathVariable(value = "id") final String batchesId) {
	    	BatchesContext batchesContext = batchesContextFactory.getObject();
	    	BatchesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(batchesId), batchesContext);
	    	BatchesResource resource = batchesResourceAssembler.toResource(model);
	        return new ResponseEntity<BatchesResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<BatchesResource>> getAllBatches() {
	    	BatchesContext batchesContext = batchesContextFactory.getObject();
	    	batchesContext.setAll("all");
	        Iterable<BatchesModel> batchesModels = businessDelegate.getCollection(batchesContext);
	        final Iterable<BatchesResource> resources = batchesResourceAssembler.toResources(batchesModels);
	        return new ResponseEntity<Iterable<BatchesResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setBatchesObjectFactory(final ObjectFactory<BatchesContext> batchesContextFactory) {
	        this.batchesContextFactory = batchesContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("batchesBusinessDelegate")
	    public void setBatchesBusinessDelegate(final IBusinessDelegate<BatchesModel, BatchesContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }

}
