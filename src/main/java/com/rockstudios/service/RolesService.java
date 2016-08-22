package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.RolesRepository;
import com.rockstudios.domain.Roles;
/*
*@Author Sankar
*/
@Component
public class RolesService implements IRolesService{

	@Autowired
	private RolesRepository rolesRepository;
	@Override
	public Roles create(Roles roles) {
		// TODO Auto-generated method stub
		return rolesRepository.save(roles);
	}

	@Override
	public void deleteRoles(String rolesId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Roles getRoles(String rolesId) {
		// TODO Auto-generated method stub
		 return rolesRepository.findOne(rolesId);
	}

	@Override
	public List<Roles> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles updateRoles(Roles roles) {
		// TODO Auto-generated method stub
	return rolesRepository.save(roles);
	}

}
