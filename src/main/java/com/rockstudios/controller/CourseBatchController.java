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
import com.rockstudios.businessdelegate.context.CourseBatchContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.resources.assemblers.CourseBatchResourceAssembler;
import com.rockstudios.resources.hal.CourseBatchResource;
	
	@RestController
	@ExposesResourceFor(value = CourseBatchResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/courseBatch", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class CourseBatchController {
	    private static final Logger LOGGER = Logger.getLogger(CourseBatchController.class);

	    private IBusinessDelegate<CourseBatchModel, CourseBatchContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<CourseBatchContext> courseBatchContextFactory;

	    @Autowired
	    private CourseBatchResourceAssembler courseBatchResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseBatchResource> createCourseBatch(@RequestBody final CourseBatchModel courseBatchModel) {
	    	
	    	CourseBatchModel model = businessDelegate.create(courseBatchModel);
	    	CourseBatchResource resource = courseBatchResourceAssembler.toResource(model);

	        return new ResponseEntity<CourseBatchResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteCourseBatch(@PathVariable(value = "id") final String courseBatchId) {

	    	CourseBatchContext courseBatchContext = courseBatchContextFactory.getObject();
	    	courseBatchContext.setCourseBatchId(courseBatchId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(courseBatchId), courseBatchContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<CourseBatchResource> edit(@PathVariable(value = "id") final String courseBatchId,
	            @RequestBody final CourseBatchModel courseBatchModel) {
	    	CourseBatchModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(courseBatchId), courseBatchModel);
	    	CourseBatchResource resource =  courseBatchResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseBatchResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseBatchResource> getCourseBatch(@PathVariable(value = "id") final String courseBatchId) {
	    	CourseBatchContext courseBatchContext = courseBatchContextFactory.getObject();
	    	CourseBatchModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(courseBatchId), courseBatchContext);
	    	CourseBatchResource resource = courseBatchResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseBatchResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<CourseBatchResource>> getAllCourseBatch() {
	    	CourseBatchContext courseBatchContext = courseBatchContextFactory.getObject();
	    	courseBatchContext.setAll("all");
	        Iterable<CourseBatchModel> courseBatchModels = businessDelegate.getCollection(courseBatchContext);
	        final Iterable<CourseBatchResource> resources = courseBatchResourceAssembler.toResources(courseBatchModels);
	        return new ResponseEntity<Iterable<CourseBatchResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setCourseBatchObjectFactory(final ObjectFactory<CourseBatchContext> courseBatchContextFactory) {
	        this.courseBatchContextFactory = courseBatchContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("courseBatchBusinessDelegate")
	    public void setCourseBatchBusinessDelegate(final IBusinessDelegate<CourseBatchModel, CourseBatchContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
