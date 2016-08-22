package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.CourseProgramContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.CourseProgram;
import com.rockstudios.model.CourseProgramModel;
import com.rockstudios.service.CourseProgramService;

/*
*@Author Sankar
*/

@Service
public class CourseProgramBusinessDelegate
		implements IBusinessDelegate<CourseProgramModel, CourseProgramContext, IKeyBuilder<String>, String> {

	@Autowired
	private CourseProgramService courseProgramService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public CourseProgramModel create(CourseProgramModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CourseProgramContext context) {

	}

	@Override
	public CourseProgramModel edit(IKeyBuilder<String> keyBuilder, CourseProgramModel model) {
		CourseProgram courseProgram = courseProgramService.getCourseProgram(keyBuilder.build().toString());
		
		courseProgram = courseProgramService.updateCourseProgram(courseProgram);
		
		return model;
	}

	@Override
	public CourseProgramModel getByKey(IKeyBuilder<String> keyBuilder, CourseProgramContext context) {
		CourseProgram courseProgram = courseProgramService.getCourseProgram(keyBuilder.build().toString());
		CourseProgramModel model = conversionService.convert(courseProgram, CourseProgramModel.class);
		return model;
	}

	@Override
	public Collection<CourseProgramModel> getCollection(CourseProgramContext context) {
		List<CourseProgram> courseProgram = new ArrayList<CourseProgram>();
		if (context.getAll() != null) {
			courseProgram = courseProgramService.getAll();
		}
		List<CourseProgramModel> courseProgramModels = (List<CourseProgramModel>) conversionService.convert(
				courseProgram, TypeDescriptor.forObject(courseProgram),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CourseProgramModel.class)));
		return courseProgramModels;
	}

}
