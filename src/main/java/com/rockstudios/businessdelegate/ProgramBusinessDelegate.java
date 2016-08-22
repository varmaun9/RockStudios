package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.ProgramContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Program;
import com.rockstudios.model.ProgramModel;
import com.rockstudios.service.ProgramService;

/*
*@Author Sankar
*/

@Service
public class ProgramBusinessDelegate
		implements IBusinessDelegate<ProgramModel, ProgramContext, IKeyBuilder<String>, String> {

	@Autowired
	private ProgramService programService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public ProgramModel create(ProgramModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProgramContext context) {

	}

	@Override
	public ProgramModel edit(IKeyBuilder<String> keyBuilder, ProgramModel model) {
		Program program = programService.getProgram(keyBuilder.build().toString());
		
		program = programService.updateProgram(program);
		
		return model;
	}

	@Override
	public ProgramModel getByKey(IKeyBuilder<String> keyBuilder, ProgramContext context) {
		Program program = programService.getProgram(keyBuilder.build().toString());
		ProgramModel model = conversionService.convert(program, ProgramModel.class);
		return model;
	}

	@Override
	public Collection<ProgramModel> getCollection(ProgramContext context) {
		List<Program> program = new ArrayList<Program>();
		if (context.getAll() != null) {
			program = programService.getAll();
		}
		List<ProgramModel> programModels = (List<ProgramModel>) conversionService.convert(
				program, TypeDescriptor.forObject(program),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ProgramModel.class)));
		return programModels;
	}

}
