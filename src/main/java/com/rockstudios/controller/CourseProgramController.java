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
import com.rockstudios.businessdelegate.context.CourseProgramContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.CourseProgramModel;
import com.rockstudios.resources.assemblers.CourseProgramResourceAssembler;
import com.rockstudios.resources.hal.CourseProgramResource;
	
	@RestController
	@ExposesResourceFor(value = CourseProgramResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/courseProgram", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class CourseProgramController {
	    private static final Logger LOGGER = Logger.getLogger(CourseProgramController.class);

	    private IBusinessDelegate<CourseProgramModel, CourseProgramContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<CourseProgramContext> courseProgramContextFactory;

	    @Autowired
	    private CourseProgramResourceAssembler courseProgramResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseProgramResource> createCourseProgram(@RequestBody final CourseProgramModel courseProgramModel) {
	    	
	    	CourseProgramModel model = businessDelegate.create(courseProgramModel);
	    	CourseProgramResource resource = courseProgramResourceAssembler.toResource(model);

	        return new ResponseEntity<CourseProgramResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteCourseProgram(@PathVariable(value = "id") final String courseProgramId) {

	    	CourseProgramContext courseProgramContext = courseProgramContextFactory.getObject();
	    	courseProgramContext.setCourseProgramId(courseProgramId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(courseProgramId), courseProgramContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<CourseProgramResource> edit(@PathVariable(value = "id") final String courseProgramId,
	            @RequestBody final CourseProgramModel courseProgramModel) {
	    	CourseProgramModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(courseProgramId), courseProgramModel);
	    	CourseProgramResource resource =  courseProgramResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseProgramResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseProgramResource> getCourseProgram(@PathVariable(value = "id") final String courseProgramId) {
	    	CourseProgramContext courseProgramContext = courseProgramContextFactory.getObject();
	    	CourseProgramModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(courseProgramId), courseProgramContext);
	    	CourseProgramResource resource = courseProgramResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseProgramResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<CourseProgramResource>> getAllCourseProgram() {
	    	CourseProgramContext courseProgramContext = courseProgramContextFactory.getObject();
	    	courseProgramContext.setAll("all");
	        Iterable<CourseProgramModel> courseProgramModels = businessDelegate.getCollection(courseProgramContext);
	        final Iterable<CourseProgramResource> resources = courseProgramResourceAssembler.toResources(courseProgramModels);
	        return new ResponseEntity<Iterable<CourseProgramResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setCourseProgramObjectFactory(final ObjectFactory<CourseProgramContext> courseProgramContextFactory) {
	        this.courseProgramContextFactory = courseProgramContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("courseProgramBusinessDelegate")
	    public void setCourseProgramBusinessDelegate(final IBusinessDelegate<CourseProgramModel, CourseProgramContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
