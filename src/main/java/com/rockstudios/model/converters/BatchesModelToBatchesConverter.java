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

import com.rockstudios.domain.Batches;
import com.rockstudios.model.BatchesModel;

/**
 * @author Jay
 *
 */
@Component("batchesModelToBatchesConverter")
public class BatchesModelToBatchesConverter implements Converter<BatchesModel, Batches> {
    @Autowired
    private ObjectFactory<Batches> batchesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Batches convert(final BatchesModel source) {
        Batches batches = batchesFactory.getObject();
        BeanUtils.copyProperties(source, batches);

        return batches;
    }

    @Autowired
    public void setBatchesFactory(final ObjectFactory<Batches> batchesFactory) {
        this.batchesFactory = batchesFactory;
    }

}
