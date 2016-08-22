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
import com.rockstudios.businessdelegate.context.CourseProgramBatchStudentContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.CourseProgramBatchStudentModel;
import com.rockstudios.resources.assemblers.CourseProgramBatchStudentResourceAssembler;
import com.rockstudios.resources.hal.CourseProgramBatchStudentResource;
	
	@RestController
	@ExposesResourceFor(value = CourseProgramBatchStudentResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/courseProgramBatchStudent", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class CourseProgramBatchStudentController {
	    private static final Logger LOGGER = Logger.getLogger(CourseProgramBatchStudentController.class);

	    private IBusinessDelegate<CourseProgramBatchStudentModel, CourseProgramBatchStudentContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<CourseProgramBatchStudentContext> courseProgramBatchStudentContextFactory;

	    @Autowired
	    private CourseProgramBatchStudentResourceAssembler courseProgramBatchStudentResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseProgramBatchStudentResource> createCourseProgramBatchStudent(@RequestBody final CourseProgramBatchStudentModel courseProgramBatchStudentModel) {
	    	
	    	CourseProgramBatchStudentModel model = businessDelegate.create(courseProgramBatchStudentModel);
	    	CourseProgramBatchStudentResource resource = courseProgramBatchStudentResourceAssembler.toResource(model);

	        return new ResponseEntity<CourseProgramBatchStudentResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteCourseProgramBatchStudent(@PathVariable(value = "id") final String courseProgramBatchStudentId) {

	    	CourseProgramBatchStudentContext courseProgramBatchStudentContext = courseProgramBatchStudentContextFactory.getObject();
	    	courseProgramBatchStudentContext.setCourseProgramBatchStudentId(courseProgramBatchStudentId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(courseProgramBatchStudentId), courseProgramBatchStudentContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<CourseProgramBatchStudentResource> edit(@PathVariable(value = "id") final String courseProgramBatchStudentId,
	            @RequestBody final CourseProgramBatchStudentModel courseProgramBatchStudentModel) {
	    	CourseProgramBatchStudentModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(courseProgramBatchStudentId), courseProgramBatchStudentModel);
	    	CourseProgramBatchStudentResource resource =  courseProgramBatchStudentResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseProgramBatchStudentResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseProgramBatchStudentResource> getCourseProgramBatchStudent(@PathVariable(value = "id") final String courseProgramBatchStudentId) {
	    	CourseProgramBatchStudentContext courseProgramBatchStudentContext = courseProgramBatchStudentContextFactory.getObject();
	    	CourseProgramBatchStudentModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(courseProgramBatchStudentId), courseProgramBatchStudentContext);
	    	CourseProgramBatchStudentResource resource = courseProgramBatchStudentResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseProgramBatchStudentResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<CourseProgramBatchStudentResource>> getAllCourseProgramBatchStudent() {
	    	CourseProgramBatchStudentContext courseProgramBatchStudentContext = courseProgramBatchStudentContextFactory.getObject();
	    	courseProgramBatchStudentContext.setAll("all");
	        Iterable<CourseProgramBatchStudentModel> courseProgramBatchStudentModels = businessDelegate.getCollection(courseProgramBatchStudentContext);
	        final Iterable<CourseProgramBatchStudentResource> resources = courseProgramBatchStudentResourceAssembler.toResources(courseProgramBatchStudentModels);
	        return new ResponseEntity<Iterable<CourseProgramBatchStudentResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setCourseProgramBatchStudentObjectFactory(final ObjectFactory<CourseProgramBatchStudentContext> courseProgramBatchStudentContextFactory) {
	        this.courseProgramBatchStudentContextFactory = courseProgramBatchStudentContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("courseProgramBatchStudentBusinessDelegate")
	    public void setCourseProgramBatchBusinessDelegate(final IBusinessDelegate<CourseProgramBatchStudentModel, CourseProgramBatchStudentContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }

}
