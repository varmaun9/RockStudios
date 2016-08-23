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

import com.rockstudios.domain.Program;
import com.rockstudios.model.ProgramModel;

/**
 * @author Jay
 *
 */
@Component("programModelToProgramConverter")
public class ProgramModelToProgramConverter implements Converter<ProgramModel, Program> {
    @Autowired
    private ObjectFactory<Program> programFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Program convert(final ProgramModel source) {
        Program program = programFactory.getObject();
        BeanUtils.copyProperties(source, program);

        return program;
    }

    @Autowired
    public void setProgramFactory(final ObjectFactory<Program> programFactory) {
        this.programFactory = programFactory;
    }

}
