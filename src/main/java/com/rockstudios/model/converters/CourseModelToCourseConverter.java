/**
 *
 */
package com.rockstudios.model.converters;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.Course;
import com.rockstudios.domain.CourseBatch;
import com.rockstudios.domain.CourseProgram;
import com.rockstudios.domain.OrganisationBranch;
import com.rockstudios.model.CourseModel;
import com.rockstudios.util.CollectionTypeDescriptor;

/**
 * @author Jay
 *
 */
@Component("courseModelToCourseConverter")
public class CourseModelToCourseConverter implements Converter<CourseModel, Course> {
	@Autowired
	private ObjectFactory<Course> courseFactory;
	@Autowired
	private ConversionService conversionService;

	@Override
	public Course convert(final CourseModel source) {
		Course course = courseFactory.getObject();
		BeanUtils.copyProperties(source, course);
		OrganisationBranch orgBranch = new OrganisationBranch();
		orgBranch.setId(source.getOrganisationBranchId());
		course.setOrganisationBranch(orgBranch);

		if (CollectionUtils.isNotEmpty(source.getCourseBatchModels())) {
			List<CourseBatch> converted = (List<CourseBatch>) conversionService.convert(source.getCourseBatchModels(),
					TypeDescriptor.forObject(source.getCourseBatchModels()),
					CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CourseBatch.class));
			course.getCourseBatches().addAll(converted);
		}
		if (CollectionUtils.isNotEmpty(source.getCourseProgramModels())) {
			List<CourseProgram> converted = (List<CourseProgram>) conversionService.convert(
					source.getCourseProgramModels(), TypeDescriptor.forObject(source.getCourseProgramModels()),
					CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CourseProgram.class));
			course.getCoursePrograms().addAll(converted);
		}
		return course;
	}

	@Autowired
	public void setCourseFactory(final ObjectFactory<Course> courseFactory) {
		this.courseFactory = courseFactory;
	}

}
