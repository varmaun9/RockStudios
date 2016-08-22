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
import com.rockstudios.businessdelegate.context.CourseContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.CourseModel;
import com.rockstudios.resources.assemblers.CourseResourceAssembler;
import com.rockstudios.resources.hal.CourseResource;
	
	@RestController
	@ExposesResourceFor(value = CourseResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/course", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class CourseController {
	    private static final Logger LOGGER = Logger.getLogger(CourseController.class);

	    private IBusinessDelegate<CourseModel, CourseContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<CourseContext> courseContextFactory;

	    @Autowired
	    private CourseResourceAssembler courseResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseResource> createCourse(@RequestBody final CourseModel courseModel) {
	    	
	    	CourseModel model = businessDelegate.create(courseModel);
	    	CourseResource resource = courseResourceAssembler.toResource(model);

	        return new ResponseEntity<CourseResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteCourse(@PathVariable(value = "id") final String courseId) {

	    	CourseContext courseContext = courseContextFactory.getObject();
	    	courseContext.setCourseId(courseId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(courseId), courseContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<CourseResource> edit(@PathVariable(value = "id") final String courseId,
	            @RequestBody final CourseModel courseModel) {
	    	CourseModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(courseId), courseModel);
	    	CourseResource resource =  courseResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<CourseResource> getCourse(@PathVariable(value = "id") final String courseId) {
	    	CourseContext courseContext = courseContextFactory.getObject();
	    	CourseModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(courseId), courseContext);
	    	CourseResource resource = courseResourceAssembler.toResource(model);
	        return new ResponseEntity<CourseResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<CourseResource>> getAllCourse() {
	    	CourseContext courseContext = courseContextFactory.getObject();
	    	courseContext.setAll("all");
	        Iterable<CourseModel> courseModels = businessDelegate.getCollection(courseContext);
	        final Iterable<CourseResource> resources = courseResourceAssembler.toResources(courseModels);
	        return new ResponseEntity<Iterable<CourseResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setCourseObjectFactory(final ObjectFactory<CourseContext> courseContextFactory) {
	        this.courseContextFactory = courseContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("courseBusinessDelegate")
	    public void setCourseBusinessDelegate(final IBusinessDelegate<CourseModel, CourseContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
