package com.rockstudios.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
*@Author Sankar
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BatchesContext implements IBusinessDelegateContext {

	private String all;
	private String batchesId;

	
	
	public String getBatchesId() {
		return batchesId;
	}

	public void setBatchesId(String batchesId) {
		this.batchesId = batchesId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
