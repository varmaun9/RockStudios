package com.rockstudios.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rockstudios.DBSequences;
import com.rockstudios.dao.UsersRepository;
import com.rockstudios.domain.Roles;
import com.rockstudios.domain.Users;

/*
*@Author Sankar
*/
@Component
public class UsersService implements IUsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private IRolesService rolesService;

	@Override
	@Transactional
	public Users create(Users users) {
		Validate.notNull(users, "pezyUsers must not be null" + users.getEmailId());
		Integer i = usersRepository.getMaxCode();
		if (i == null || i == 0) {
			i = 0;
			users.setUserCount(i + 1);
		} else {
			users.setUserCount(i + 1);
		}
		Integer co = i + 1;
		String m = DBSequences.USERS.getSequenceName();
		String mc = m.concat(co.toString());
		users.setUserCode(mc);
		if (users.getUserType() != null) {
			users.setUserType(users.getUserType());
		} else {
			users.setUserType("CUSTOMER");
		}
		boolean emailExists = checkEmailExists(users.getEmailId().toLowerCase());
		boolean phoneNoExists = checkPhoneNoExists(users.getPhoneNo());
		if (emailExists || phoneNoExists) {
			if (emailExists && phoneNoExists) {
				users.setEmailStatus("DUPLICATEEM");
				return users;
			}
			if (emailExists) {
				users.setEmailStatus("DUPLICATEE");
				return users;
			}
			if (phoneNoExists) {
				users.setEmailStatus("DUPLICATEM");
				return users;
			}
		} else {
			signup(users);
		}
		if (users.getId() != null) {
			Roles r = new Roles();
			r.setRoleDetails("Role created");
			r.setStatus("TRUE");
			if (users.getUserType().equals("CUSTOMER")) {
				r.setRoleName("ROLE_USER");
			}
			if (users.getUserType() != null) {
				if (users.getUserType().equals("ADMIN")) {
					r.setRoleName("ROLE_ADMIN");
				}
				if (users.getUserType().equals("EMPLOYEE")) {
					r.setRoleName("ROLE_EMPLOYEE");
				}
			}
			r.setUsers(users);
			r = rolesService.create(r);
		}
		return users;
	}

	private void signup(Users users) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(hashedPassword);
		users.setEmailId(users.getEmailId());
		users.setStatus("ACTIVE");
		users = usersRepository.save(users);

	}

	/**
	 * @param lowerCase
	 * @return
	 */
	private boolean checkEmailExists(final String email) {
		return usersRepository.findByEmailId(email) != null;
	}

	/**
	 * @param mobileNo
	 * @return
	 */
	private boolean checkPhoneNoExists(final String phoneNo) {
		return usersRepository.findByPhoneNo(phoneNo) != null;
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
		return (List<Users>) usersRepository.findAll();
	}

	@Override
	public Users updateUsers(Users users) {
		// TODO Auto-generated method stub
		return usersRepository.save(users);
	}

}
