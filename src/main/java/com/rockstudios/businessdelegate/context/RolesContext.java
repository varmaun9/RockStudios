package com.rockstudios.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
*@Author Sankar
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RolesContext implements IBusinessDelegateContext {

	private String all;
	private String rolesId;

	
	
	public String getRolesId() {
		return rolesId;
	}

	public void setRolesId(String rolesId) {
		this.rolesId = rolesId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
