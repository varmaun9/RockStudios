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

import com.rockstudios.domain.CourseBatch;
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.model.CourseProgramBatchStudentModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("courseBatchToCourseBatchModelConverter")
public class CourseBatchToCourseBatchModelConverter
        implements Converter<CourseBatch, CourseBatchModel> {
    @Autowired
    private ObjectFactory<CourseBatchModel> courseBatchModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseBatchModel convert(final CourseBatch source) {
        CourseBatchModel courseBatchModel = courseBatchModelFactory.getObject();
        BeanUtils.copyProperties(source, courseBatchModel);

        if (CollectionUtils.isNotEmpty(source.getCourseProgramBatchStudents())) {
            List<CourseProgramBatchStudentModel> converted = (List<CourseProgramBatchStudentModel>) conversionService.convert(
                    source.getCourseProgramBatchStudents(), TypeDescriptor.forObject(source.getCourseProgramBatchStudents()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseProgramBatchStudentModel.class));
            courseBatchModel.getCourseProgramBatchStudentModels().addAll(converted);
        }
        return courseBatchModel;
    }

    @Autowired
    public void setCourseBatchModelFactory(
            final ObjectFactory<CourseBatchModel> courseBatchModelFactory) {
        this.courseBatchModelFactory = courseBatchModelFactory;
    }
}
