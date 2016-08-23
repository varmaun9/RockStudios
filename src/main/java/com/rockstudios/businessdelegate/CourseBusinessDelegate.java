package com.rockstudios.businessdelegate;

import static org.springframework.core.convert.TypeDescriptor.forObject;
import static org.springframework.core.convert.TypeDescriptor.valueOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
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
		validateModel(model);
		Course course = courseService
				.create((Course) conversionService.convert(model, forObject(model), valueOf(Course.class)));
		model = convertToCourseModel(course);
		return model;
	}

	private CourseModel convertToCourseModel(Course course) {
		return (CourseModel) conversionService.convert(course, forObject(course),
				valueOf(CourseModel.class));
	}

	private void validateModel(CourseModel model) {
		Validate.notNull(model, "Invalid Input");
		Validate.notBlank(model.getCourseName(), "Invalid courseName");
		Validate.notBlank(model.getCourseCode(), "Invalid courseCode");
		Validate.notBlank(model.getOrganisationBranchId(),"Invalid organisationBranchId");
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
