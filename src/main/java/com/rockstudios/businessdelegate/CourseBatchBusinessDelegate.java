package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.CourseBatchContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.CourseBatch;
import com.rockstudios.model.CourseBatchModel;
import com.rockstudios.service.CourseBatchService;

/*
*@Author Sankar
*/

@Service
public class CourseBatchBusinessDelegate
		implements IBusinessDelegate<CourseBatchModel, CourseBatchContext, IKeyBuilder<String>, String> {

	@Autowired
	private CourseBatchService courseBatchService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public CourseBatchModel create(CourseBatchModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CourseBatchContext context) {

	}

	@Override
	public CourseBatchModel edit(IKeyBuilder<String> keyBuilder, CourseBatchModel model) {
		CourseBatch courseBatch = courseBatchService.getCourseBatch(keyBuilder.build().toString());
		
		courseBatch = courseBatchService.updateCourseBatch(courseBatch);
		
		return model;
	}

	@Override
	public CourseBatchModel getByKey(IKeyBuilder<String> keyBuilder, CourseBatchContext context) {
		CourseBatch courseBatch = courseBatchService.getCourseBatch(keyBuilder.build().toString());
		CourseBatchModel model = conversionService.convert(courseBatch, CourseBatchModel.class);
		return model;
	}

	@Override
	public Collection<CourseBatchModel> getCollection(CourseBatchContext context) {
		List<CourseBatch> courseBatch = new ArrayList<CourseBatch>();
		if (context.getAll() != null) {
			courseBatch = courseBatchService.getAll();
		}
		List<CourseBatchModel> courseBatchModels = (List<CourseBatchModel>) conversionService.convert(
				courseBatch, TypeDescriptor.forObject(courseBatch),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CourseBatchModel.class)));
		return courseBatchModels;
	}

}
