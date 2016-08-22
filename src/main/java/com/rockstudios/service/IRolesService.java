package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Roles;
/*
*@Author Sankar
*/
public interface IRolesService {
	
	Roles create(Roles roles);

	void deleteRoles(String rolesId);

	Roles getRoles(String rolesId);

	List<Roles> getAll();

	Roles updateRoles(Roles roles);
}
