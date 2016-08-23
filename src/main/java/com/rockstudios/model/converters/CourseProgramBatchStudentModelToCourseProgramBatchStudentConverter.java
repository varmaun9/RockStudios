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

import com.rockstudios.domain.CourseProgramBatchStudent;
import com.rockstudios.model.CourseProgramBatchStudentModel;

/**
 * @author Jay
 *
 */
@Component("courseProgramBatchStudentModelToCourseProgramBatchStudentConverter")
public class CourseProgramBatchStudentModelToCourseProgramBatchStudentConverter implements Converter<CourseProgramBatchStudentModel, CourseProgramBatchStudent> {
    @Autowired
    private ObjectFactory<CourseProgramBatchStudent> courseProgramBatchStudentFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseProgramBatchStudent convert(final CourseProgramBatchStudentModel source) {
        CourseProgramBatchStudent courseProgramBatchStudent = courseProgramBatchStudentFactory.getObject();
        BeanUtils.copyProperties(source, courseProgramBatchStudent);

        return courseProgramBatchStudent;
    }

    @Autowired
    public void setCourseProgramBatchStudentFactory(final ObjectFactory<CourseProgramBatchStudent> courseProgramBatchStudentFactory) {
        this.courseProgramBatchStudentFactory = courseProgramBatchStudentFactory;
    }

}
