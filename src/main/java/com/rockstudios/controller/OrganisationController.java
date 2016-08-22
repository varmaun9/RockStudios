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
import com.rockstudios.businessdelegate.context.OrganisationContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.OrganisationModel;
import com.rockstudios.resources.assemblers.OrganisationResourceAssembler;
import com.rockstudios.resources.hal.OrganisationResource;
	
	@RestController
	@ExposesResourceFor(value = OrganisationResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/organisation", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class OrganisationController {
	    private static final Logger LOGGER = Logger.getLogger(OrganisationController.class);

	    private IBusinessDelegate<OrganisationModel, OrganisationContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<OrganisationContext> organisationContextFactory;

	    @Autowired
	    private OrganisationResourceAssembler organisationResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<OrganisationResource> createOrganisation(@RequestBody final OrganisationModel organisationModel) {
	    	
	    	OrganisationModel model = businessDelegate.create(organisationModel);
	    	OrganisationResource resource = organisationResourceAssembler.toResource(model);

	        return new ResponseEntity<OrganisationResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteOrganisation(@PathVariable(value = "id") final String organisationId) {

	    	OrganisationContext organisationContext = organisationContextFactory.getObject();
	    	organisationContext.setOrganisationId(organisationId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(organisationId), organisationContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<OrganisationResource> edit(@PathVariable(value = "id") final String organisationId,
	            @RequestBody final OrganisationModel organisationModel) {
	    	OrganisationModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(organisationId), organisationModel);
	    	OrganisationResource resource =  organisationResourceAssembler.toResource(model);
	        return new ResponseEntity<OrganisationResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<OrganisationResource> getOrganisation(@PathVariable(value = "id") final String organisationId) {
	    	OrganisationContext organisationContext = organisationContextFactory.getObject();
	    	OrganisationModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(organisationId), organisationContext);
	    	OrganisationResource resource = organisationResourceAssembler.toResource(model);
	        return new ResponseEntity<OrganisationResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<OrganisationResource>> getAllOrganisation() {
	    	OrganisationContext organisationContext = organisationContextFactory.getObject();
	    	organisationContext.setAll("all");
	        Iterable<OrganisationModel> organisationModels = businessDelegate.getCollection(organisationContext);
	        final Iterable<OrganisationResource> resources = organisationResourceAssembler.toResources(organisationModels);
	        return new ResponseEntity<Iterable<OrganisationResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setOrganisationObjectFactory(final ObjectFactory<OrganisationContext> organisationContextFactory) {
	        this.organisationContextFactory = organisationContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("organisationBusinessDelegate")
	    public void setOrganisationBusinessDelegate(final IBusinessDelegate<OrganisationModel, OrganisationContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
