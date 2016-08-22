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
import com.rockstudios.businessdelegate.context.UsersContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.UsersModel;
import com.rockstudios.resources.assemblers.UsersResourceAssembler;
import com.rockstudios.resources.hal.UsersResource;
	
	@RestController
	@ExposesResourceFor(value = UsersResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class UsersController {
	    private static final Logger LOGGER = Logger.getLogger(UsersController.class);

	    private IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<UsersContext> usersContextFactory;

	    @Autowired
	    private UsersResourceAssembler usersResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<UsersResource> createUsers(@RequestBody final UsersModel usersModel) {
	    	
	    	UsersModel model = businessDelegate.create(usersModel);
	    	UsersResource resource = usersResourceAssembler.toResource(model);

	        return new ResponseEntity<UsersResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteUsers(@PathVariable(value = "id") final String usersId) {

	    	UsersContext usersContext = usersContextFactory.getObject();
	    	usersContext.setUsersId(usersId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(usersId), usersContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<UsersResource> edit(@PathVariable(value = "id") final String usersId,
	            @RequestBody final UsersModel usersModel) {
	    	UsersModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(usersId), usersModel);
	    	UsersResource resource =  usersResourceAssembler.toResource(model);
	        return new ResponseEntity<UsersResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<UsersResource> getUsers(@PathVariable(value = "id") final String usersId) {
	    	UsersContext usersContext = usersContextFactory.getObject();
	    	UsersModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(usersId), usersContext);
	    	UsersResource resource = usersResourceAssembler.toResource(model);
	        return new ResponseEntity<UsersResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<UsersResource>> getAllUsers() {
	    	UsersContext usersContext = usersContextFactory.getObject();
	    	usersContext.setAll("all");
	        Iterable<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
	        final Iterable<UsersResource> resources = usersResourceAssembler.toResources(usersModels);
	        return new ResponseEntity<Iterable<UsersResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setUsersObjectFactory(final ObjectFactory<UsersContext> usersContextFactory) {
	        this.usersContextFactory = usersContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("usersBusinessDelegate")
	    public void setUsersBusinessDelegate(final IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
