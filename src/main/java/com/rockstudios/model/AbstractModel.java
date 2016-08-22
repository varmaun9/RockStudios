package com.rockstudios.model;

import com.rockstudios.businessdelegate.model.IModel;

public abstract class AbstractModel implements IModel {

	protected String id;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eelectricals.domain.IDomain#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eelectricals.domain.IDomain#setId(java.lang.String)
	 */
	@Override
	public void setId(final String id) {
		this.id = id;
	}

}
