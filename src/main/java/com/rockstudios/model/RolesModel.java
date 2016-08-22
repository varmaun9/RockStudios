package com.rockstudios.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("rolesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RolesModel extends AbstractModel {

	private String usersId;
	private String roleName;
	private String roleDetails;
	private String status;

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(String roleDetails) {
		this.roleDetails = roleDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
