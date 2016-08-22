package com.rockstudios.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "roles", collectionRelation = "roles")
public class RolesResource extends ResourceWithEmdedded {
	private String rolesId;
	private String usersId;
	private String roleName;
	private String roleDetails;
	private String status;

	public String getRolesId() {
		return rolesId;
	}

	public void setRolesId(String rolesId) {
		this.rolesId = rolesId;
	}

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
