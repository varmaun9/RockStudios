package com.rockstudios.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import com.rockstudios.businessdelegate.context.UsersContext;
import com.rockstudios.businessdelegate.model.IKeyBuilder;
import com.rockstudios.domain.Users;
import com.rockstudios.model.UsersModel;
import com.rockstudios.service.UsersService;

/*
*@Author Sankar
*/

@Service
public class UsersBusinessDelegate
		implements IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> {

	@Autowired
	private UsersService usersService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public UsersModel create(UsersModel model) {

		
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, UsersContext context) {

	}

	@Override
	public UsersModel edit(IKeyBuilder<String> keyBuilder, UsersModel model) {
		Users users = usersService.getUsers(keyBuilder.build().toString());
		
		users = usersService.updateUsers(users);
		
		return model;
	}

	@Override
	public UsersModel getByKey(IKeyBuilder<String> keyBuilder, UsersContext context) {
		Users users = usersService.getUsers(keyBuilder.build().toString());
		UsersModel model = conversionService.convert(users, UsersModel.class);
		return model;
	}

	@Override
	public Collection<UsersModel> getCollection(UsersContext context) {
		List<Users> users = new ArrayList<Users>();
		if (context.getAll() != null) {
			users = usersService.getAll();
		}
		List<UsersModel> usersModels = (List<UsersModel>) conversionService.convert(
				users, TypeDescriptor.forObject(users),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersModel.class)));
		return usersModels;
	}

}
