package com.rockstudios.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.CourseProgramBatchStudent;
import com.rockstudios.model.CourseProgramBatchStudentModel;

@Component("courseProgramBatchStudentToCourseProgramBatchStudentModelConverter")
public class CourseProgramBatchStudentToCourseProgramBatchStudentModelConverter
        implements Converter<CourseProgramBatchStudent, CourseProgramBatchStudentModel> {
    @Autowired
    private ObjectFactory<CourseProgramBatchStudentModel> courseProgramBatchStudentModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseProgramBatchStudentModel convert(final CourseProgramBatchStudent source) {
        CourseProgramBatchStudentModel courseProgramBatchStudentModel = courseProgramBatchStudentModelFactory.getObject();
        BeanUtils.copyProperties(source, courseProgramBatchStudentModel);

        return courseProgramBatchStudentModel;
    }

    @Autowired
    public void setCourseProgramBatchStudentModelFactory(
            final ObjectFactory<CourseProgramBatchStudentModel> courseProgramBatchStudentModelFactory) {
        this.courseProgramBatchStudentModelFactory = courseProgramBatchStudentModelFactory;
    }
}
