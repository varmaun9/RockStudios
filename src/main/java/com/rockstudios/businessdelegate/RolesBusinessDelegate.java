package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.RolesContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Roles;
import com.rockstudios.model.RolesModel;
import com.rockstudios.service.RolesService;

/*
*@Author Sankar
*/

@Service
public class RolesBusinessDelegate
		implements IBusinessDelegate<RolesModel, RolesContext, IKeyBuilder<String>, String> {

	@Autowired
	private RolesService rolesService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public RolesModel create(RolesModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, RolesContext context) {

	}

	@Override
	public RolesModel edit(IKeyBuilder<String> keyBuilder, RolesModel model) {
		Roles roles = rolesService.getRoles(keyBuilder.build().toString());
		
		roles = rolesService.updateRoles(roles);
		
		return model;
	}

	@Override
	public RolesModel getByKey(IKeyBuilder<String> keyBuilder, RolesContext context) {
		Roles roles = rolesService.getRoles(keyBuilder.build().toString());
		RolesModel model = conversionService.convert(roles, RolesModel.class);
		return model;
	}

	@Override
	public Collection<RolesModel> getCollection(RolesContext context) {
		List<Roles> roles = new ArrayList<Roles>();
		if (context.getAll() != null) {
			roles = rolesService.getAll();
		}
		List<RolesModel> rolesModels = (List<RolesModel>) conversionService.convert(
				roles, TypeDescriptor.forObject(roles),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RolesModel.class)));
		return rolesModels;
	}

}
