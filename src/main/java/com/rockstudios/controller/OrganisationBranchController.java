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
import com.rockstudios.businessdelegate.context.OrganisationBranchContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.OrganisationBranchModel;
import com.rockstudios.resources.assemblers.OrganisationBranchResourceAssembler;
import com.rockstudios.resources.hal.OrganisationBranchResource;
	
	@RestController
	@ExposesResourceFor(value = OrganisationBranchResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/organisationBranch", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class OrganisationBranchController {
	    private static final Logger LOGGER = Logger.getLogger(OrganisationBranchController.class);

	    private IBusinessDelegate<OrganisationBranchModel, OrganisationBranchContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<OrganisationBranchContext> organisationBranchContextFactory;

	    @Autowired
	    private OrganisationBranchResourceAssembler organisationBranchResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<OrganisationBranchResource> createOrganisationBranch(@RequestBody final OrganisationBranchModel organisationBranchModel) {
	    	
	    	OrganisationBranchModel model = businessDelegate.create(organisationBranchModel);
	    	OrganisationBranchResource resource = organisationBranchResourceAssembler.toResource(model);

	        return new ResponseEntity<OrganisationBranchResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteOrganisationBranch(@PathVariable(value = "id") final String organisationBranchId) {

	    	OrganisationBranchContext organisationBranchContext = organisationBranchContextFactory.getObject();
	    	organisationBranchContext.setOrganisationBranchId(organisationBranchId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(organisationBranchId), organisationBranchContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<OrganisationBranchResource> edit(@PathVariable(value = "id") final String organisationBranchId,
	            @RequestBody final OrganisationBranchModel organisationBranchModel) {
	    	OrganisationBranchModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(organisationBranchId), organisationBranchModel);
	    	OrganisationBranchResource resource =  organisationBranchResourceAssembler.toResource(model);
	        return new ResponseEntity<OrganisationBranchResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<OrganisationBranchResource> getOrganisationBranch(@PathVariable(value = "id") final String organisationBranchId) {
	    	OrganisationBranchContext organisationBranchContext = organisationBranchContextFactory.getObject();
	    	OrganisationBranchModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(organisationBranchId), organisationBranchContext);
	    	OrganisationBranchResource resource = organisationBranchResourceAssembler.toResource(model);
	        return new ResponseEntity<OrganisationBranchResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<OrganisationBranchResource>> getAllOrganisationBranch() {
	    	OrganisationBranchContext organisationBranchContext = organisationBranchContextFactory.getObject();
	    	organisationBranchContext.setAll("all");
	        Iterable<OrganisationBranchModel> organisationBranchModels = businessDelegate.getCollection(organisationBranchContext);
	        final Iterable<OrganisationBranchResource> resources = organisationBranchResourceAssembler.toResources(organisationBranchModels);
	        return new ResponseEntity<Iterable<OrganisationBranchResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setOrganisationBranchObjectFactory(final ObjectFactory<OrganisationBranchContext> organisationBranchContextFactory) {
	        this.organisationBranchContextFactory = organisationBranchContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("organisationBranchBusinessDelegate")
	    public void setOrganisationBranchBusinessDelegate(final IBusinessDelegate<OrganisationBranchModel, OrganisationBranchContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
