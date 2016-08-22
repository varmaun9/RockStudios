package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.CourseContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Course;
import com.rockstudios.model.CourseModel;
import com.rockstudios.service.CourseService;

/*
*@Author Sankar
*/

@Service
public class CourseBusinessDelegate
		implements IBusinessDelegate<CourseModel, CourseContext, IKeyBuilder<String>, String> {

	@Autowired
	private CourseService courseService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public CourseModel create(CourseModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CourseContext context) {

	}

	@Override
	public CourseModel edit(IKeyBuilder<String> keyBuilder, CourseModel model) {
		Course course = courseService.getCourse(keyBuilder.build().toString());
		
		course = courseService.updateCourse(course);
		
		return model;
	}

	@Override
	public CourseModel getByKey(IKeyBuilder<String> keyBuilder, CourseContext context) {
		Course course = courseService.getCourse(keyBuilder.build().toString());
		CourseModel model = conversionService.convert(course, CourseModel.class);
		return model;
	}

	@Override
	public Collection<CourseModel> getCollection(CourseContext context) {
		List<Course> course = new ArrayList<Course>();
		if (context.getAll() != null) {
			course = courseService.getAll();
		}
		List<CourseModel> courseModels = (List<CourseModel>) conversionService.convert(
				course, TypeDescriptor.forObject(course),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CourseModel.class)));
		return courseModels;
	}

}
