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
import com.rockstudios.businessdelegate.context.ProgramContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.businessdelegate.model.SimpleIdKeyBuilder;
import com.rockstudios.model.ProgramModel;
import com.rockstudios.resources.assemblers.ProgramResourceAssembler;
import com.rockstudios.resources.hal.ProgramResource;
	
	@RestController
	@ExposesResourceFor(value = ProgramResource.class)
	@EnableHypermediaSupport(type = { HypermediaType.HAL })
	@RequestMapping(value = "/program", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public class ProgramController {
	    private static final Logger LOGGER = Logger.getLogger(ProgramController.class);

	    private IBusinessDelegate<ProgramModel, ProgramContext, IKeyBuilder<String>, String> businessDelegate;
	    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	    private ObjectFactory<ProgramContext> programContextFactory;

	    @Autowired
	    private ProgramResourceAssembler programResourceAssembler;

	    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<ProgramResource> createProgram(@RequestBody final ProgramModel programModel) {
	    	
	    	ProgramModel model = businessDelegate.create(programModel);
	    	ProgramResource resource = programResourceAssembler.toResource(model);

	        return new ResponseEntity<ProgramResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public void deleteProgram(@PathVariable(value = "id") final String programId) {

	    	ProgramContext programContext = programContextFactory.getObject();
	    	programContext.setProgramId(programId);
	        businessDelegate.delete(keyBuilderFactory.getObject().withId(programId), programContext);

	    }

	    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<ProgramResource> edit(@PathVariable(value = "id") final String programId,
	            @RequestBody final ProgramModel programModel) {
	    	ProgramModel model =   businessDelegate.edit(keyBuilderFactory.getObject().withId(programId), programModel);
	    	ProgramResource resource =  programResourceAssembler.toResource(model);
	        return new ResponseEntity<ProgramResource>(resource, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<ProgramResource> getProgram(@PathVariable(value = "id") final String programId) {
	    	ProgramContext programContext = programContextFactory.getObject();
	    	ProgramModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(programId), programContext);
	    	ProgramResource resource = programResourceAssembler.toResource(model);
	        return new ResponseEntity<ProgramResource>(resource, HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	    @ResponseBody
	    public ResponseEntity<Iterable<ProgramResource>> getAllProgram() {
	    	ProgramContext programContext = programContextFactory.getObject();
	    	programContext.setAll("all");
	        Iterable<ProgramModel> programModels = businessDelegate.getCollection(programContext);
	        final Iterable<ProgramResource> resources = programResourceAssembler.toResources(programModels);
	        return new ResponseEntity<Iterable<ProgramResource>>(resources, HttpStatus.OK);
	    }

	    @Autowired
	    public void setProgramObjectFactory(final ObjectFactory<ProgramContext> programContextFactory) {
	        this.programContextFactory = programContextFactory;
	    }

	    /**
	     * @param factory
	     */
	    @Resource
	    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
	        keyBuilderFactory = factory;
	    }

	    @Autowired
	    @Qualifier("programBusinessDelegate")
	    public void setProgramBusinessDelegate(final IBusinessDelegate<ProgramModel, ProgramContext, IKeyBuilder<String>, String> businessDelegate) {
	        this.businessDelegate = businessDelegate;
	    }
}
