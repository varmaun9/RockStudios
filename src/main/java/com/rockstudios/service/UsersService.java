package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.UsersRepository;
import com.rockstudios.domain.Users;
/*
*@Author Sankar
*/
@Component
public class UsersService implements IUsersService{

	@Autowired
	private UsersRepository usersRepository;
	@Override
	public Users create(Users users) {
		// TODO Auto-generated method stub
		return usersRepository.save(users);
	}

	@Override
	public void deleteUsers(String usersId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users getUsers(String usersId) {
		// TODO Auto-generated method stub
		 return usersRepository.findOne(usersId);
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUsers(Users users) {
		// TODO Auto-generated method stub
	return usersRepository.save(users);
	}

}
