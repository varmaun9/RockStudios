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

import com.rockstudios.domain.Program;
import com.rockstudios.model.CourseProgramModel;
import com.rockstudios.model.ProgramModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("programToProgramModelConverter")
public class ProgramToProgramModelConverter
        implements Converter<Program, ProgramModel> {
    @Autowired
    private ObjectFactory<ProgramModel> programModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProgramModel convert(final Program source) {
        ProgramModel programModel = programModelFactory.getObject();
        BeanUtils.copyProperties(source, programModel);

        if (CollectionUtils.isNotEmpty(source.getCoursePrograms())) {
            List<CourseProgramModel> converted = (List<CourseProgramModel>) conversionService.convert(
                    source.getCoursePrograms(), TypeDescriptor.forObject(source.getCoursePrograms()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseProgramModel.class));
            programModel.getCourseProgramModels().addAll(converted);
        }
        return programModel;
    }

    @Autowired
    public void setProgramModelFactory(
            final ObjectFactory<ProgramModel> programModelFactory) {
        this.programModelFactory = programModelFactory;
    }
}
