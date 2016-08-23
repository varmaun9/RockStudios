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
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.model.CourseModel;
import com.rockstudios.model.CourseProgramModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("courseToCourseModelConverter")
public class CourseToCourseModelConverter
        implements Converter<Course, CourseModel> {
    @Autowired
    private ObjectFactory<CourseModel> courseModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseModel convert(final Course source) {
        CourseModel courseModel = courseModelFactory.getObject();
        BeanUtils.copyProperties(source, courseModel);

        if (CollectionUtils.isNotEmpty(source.getCourseBatches())) {
            List<CourseBatchModel> converted = (List<CourseBatchModel>) conversionService.convert(
                    source.getCourseBatches(), TypeDescriptor.forObject(source.getCourseBatches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseBatchModel.class));
            courseModel.getCourseBatchModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCoursePrograms())) {
            List<CourseProgramModel> converted = (List<CourseProgramModel>) conversionService.convert(
                    source.getCoursePrograms(), TypeDescriptor.forObject(source.getCoursePrograms()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseProgramModel.class));
            courseModel.getCourseProgramModels().addAll(converted);
        }
        return courseModel;
    }

    @Autowired
    public void setCourseModelFactory(
            final ObjectFactory<CourseModel> courseModelFactory) {
        this.courseModelFactory = courseModelFactory;
    }
}
