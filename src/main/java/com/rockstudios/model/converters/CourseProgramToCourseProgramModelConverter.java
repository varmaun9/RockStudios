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

import com.rockstudios.domain.CourseProgram;
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.model.CourseProgramBatchStudentModel;
import com.rockstudios.model.CourseProgramModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("courseProgramToCourseProgramModelConverter")
public class CourseProgramToCourseProgramModelConverter
        implements Converter<CourseProgram, CourseProgramModel> {
    @Autowired
    private ObjectFactory<CourseProgramModel> courseProgramModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseProgramModel convert(final CourseProgram source) {
        CourseProgramModel courseProgramModel = courseProgramModelFactory.getObject();
        BeanUtils.copyProperties(source, courseProgramModel);

        if (CollectionUtils.isNotEmpty(source.getCourseProgramBatchStudents())) {
            List<CourseProgramBatchStudentModel> converted = (List<CourseProgramBatchStudentModel>) conversionService.convert(
                    source.getCourseProgramBatchStudents(), TypeDescriptor.forObject(source.getCourseProgramBatchStudents()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseProgramBatchStudentModel.class));
            courseProgramModel.getCourseProgramBatchStudentModels().addAll(converted);
        }
        return courseProgramModel;
    }

    @Autowired
    public void setCourseProgramModelFactory(
            final ObjectFactory<CourseProgramModel> courseProgramModelFactory) {
        this.courseProgramModelFactory = courseProgramModelFactory;
    }
}
