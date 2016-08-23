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

import com.rockstudios.domain.CourseBatch;
import com.rockstudios.model.CourseBatchModel;

/**
 * @author Jay
 *
 */
@Component("courseBatchModelToCourseBatchConverter")
public class CourseBatchModelToCourseBatchConverter implements Converter<CourseBatchModel, CourseBatch> {
    @Autowired
    private ObjectFactory<CourseBatch> courseBatchFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CourseBatch convert(final CourseBatchModel source) {
        CourseBatch courseBatch = courseBatchFactory.getObject();
        BeanUtils.copyProperties(source, courseBatch);

        return courseBatch;
    }

    @Autowired
    public void setCourseBatchFactory(final ObjectFactory<CourseBatch> courseBatchFactory) {
        this.courseBatchFactory = courseBatchFactory;
    }

}
