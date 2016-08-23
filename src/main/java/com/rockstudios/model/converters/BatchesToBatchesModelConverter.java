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

import com.rockstudios.domain.Batches;
import com.rockstudios.model.BatchesModel;
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.model.CourseProgramBatchStudentModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("batchesToBatchesModelConverter")
public class BatchesToBatchesModelConverter
        implements Converter<Batches, BatchesModel> {
    @Autowired
    private ObjectFactory<BatchesModel> batchesModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public BatchesModel convert(final Batches source) {
        BatchesModel batchesModel = batchesModelFactory.getObject();
        BeanUtils.copyProperties(source, batchesModel);

        if (CollectionUtils.isNotEmpty(source.getCourseBatches())) {
            List<CourseBatchModel> converted = (List<CourseBatchModel>) conversionService.convert(
                    source.getCourseBatches(), TypeDescriptor.forObject(source.getCourseBatches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseProgramBatchStudentModel.class));
            batchesModel.getCourseBatchModels().addAll(converted);
        }
        return batchesModel;
    }

    @Autowired
    public void setBatchesModelFactory(
            final ObjectFactory<BatchesModel> batchesModelFactory) {
        this.batchesModelFactory = batchesModelFactory;
    }
}
