package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.CourseProgramBatchStudentContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.CourseProgramBatchStudent;
import com.rockstudios.model.CourseProgramBatchStudentModel;
import com.rockstudios.service.CourseProgramBatchStudentService;

/*
*@Author Sankar
*/

@Service
public class CourseProgramBatchStudentBusinessDelegate
		implements IBusinessDelegate<CourseProgramBatchStudentModel, CourseProgramBatchStudentContext, IKeyBuilder<String>, String> {

	@Autowired
	private CourseProgramBatchStudentService courseProgramBatchStudentService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public CourseProgramBatchStudentModel create(CourseProgramBatchStudentModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CourseProgramBatchStudentContext context) {

	}

	@Override
	public CourseProgramBatchStudentModel edit(IKeyBuilder<String> keyBuilder, CourseProgramBatchStudentModel model) {
		CourseProgramBatchStudent courseProgramBatchStudent = courseProgramBatchStudentService.getCourseProgramBatchStudent(keyBuilder.build().toString());
		
		courseProgramBatchStudent = courseProgramBatchStudentService.updateCourseProgramBatchStudent(courseProgramBatchStudent);
		
		return model;
	}

	@Override
	public CourseProgramBatchStudentModel getByKey(IKeyBuilder<String> keyBuilder, CourseProgramBatchStudentContext context) {
		CourseProgramBatchStudent courseProgramBatchStudent = courseProgramBatchStudentService.getCourseProgramBatchStudent(keyBuilder.build().toString());
		CourseProgramBatchStudentModel model = conversionService.convert(courseProgramBatchStudent, CourseProgramBatchStudentModel.class);
		return model;
	}

	@Override
	public Collection<CourseProgramBatchStudentModel> getCollection(CourseProgramBatchStudentContext context) {
		List<CourseProgramBatchStudent> courseProgramBatchStudent = new ArrayList<CourseProgramBatchStudent>();
		if (context.getAll() != null) {
			courseProgramBatchStudent = courseProgramBatchStudentService.getAll();
		}
		List<CourseProgramBatchStudentModel> courseProgramBatchStudentModels = (List<CourseProgramBatchStudentModel>) conversionService.convert(
				courseProgramBatchStudent, TypeDescriptor.forObject(courseProgramBatchStudent),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CourseProgramBatchStudentModel.class)));
		return courseProgramBatchStudentModels;
	}

}
