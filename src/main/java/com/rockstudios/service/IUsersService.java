package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Users;
/*
*@Author Sankar
*/
public interface IUsersService {
	
	Users create(Users users);

	void deleteUsers(String usersId);

	Users getUsers(String usersId);

	List<Users> getAll();

	Users updateUsers(Users users);
}
