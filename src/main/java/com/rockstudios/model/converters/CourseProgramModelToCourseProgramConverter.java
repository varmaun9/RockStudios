/**
 *
 */
package com.rockstudios.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.CourseProgram;
import com.rockstudios.model.CourseProgramModel;

/**
 * @author Jay
 *
 */
@Component("courseProgramModelToCourseProgramConverter")
public class CourseProgramModelToCourseProgramConverter implements Converter<CourseProgramModel, CourseProgram> {
    @Autowired
    private ObjectFactory<CourseProgram> courseProgramFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseProgram convert(final CourseProgramModel source) {
        CourseProgram courseProgram = courseProgramFactory.getObject();
        BeanUtils.copyProperties(source, courseProgram);

        return courseProgram;
    }

    @Autowired
    public void setCourseProgramFactory(final ObjectFactory<CourseProgram> courseProgramFactory) {
        this.courseProgramFactory = courseProgramFactory;
    }

}
