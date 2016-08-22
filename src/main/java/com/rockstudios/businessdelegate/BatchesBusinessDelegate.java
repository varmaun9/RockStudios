package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.BatchesContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Batches;
import com.rockstudios.model.BatchesModel;
import com.rockstudios.service.BatchesService;

/*
*@Author Sankar
*/

@Service
public class BatchesBusinessDelegate
		implements IBusinessDelegate<BatchesModel, BatchesContext, IKeyBuilder<String>, String> {

	@Autowired
	private BatchesService batchesService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public BatchesModel create(BatchesModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, BatchesContext context) {

	}

	@Override
	public BatchesModel edit(IKeyBuilder<String> keyBuilder, BatchesModel model) {
		Batches batches = batchesService.getBatches(keyBuilder.build().toString());
		
		batches = batchesService.updateBatches(batches);
		
		return model;
	}

	@Override
	public BatchesModel getByKey(IKeyBuilder<String> keyBuilder, BatchesContext context) {
		Batches batches = batchesService.getBatches(keyBuilder.build().toString());
		BatchesModel model = conversionService.convert(batches, BatchesModel.class);
		return model;
	}

	@Override
	public Collection<BatchesModel> getCollection(BatchesContext context) {
		List<Batches> batches = new ArrayList<Batches>();
		if (context.getAll() != null) {
			batches = batchesService.getAll();
		}
		List<BatchesModel> batchesModels = (List<BatchesModel>) conversionService.convert(
				batches, TypeDescriptor.forObject(batches),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BatchesModel.class)));
		return batchesModels;
	}

}
