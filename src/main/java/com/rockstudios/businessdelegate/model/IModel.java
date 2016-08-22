package com.rockstudios.businessdelegate.model;

import java.io.Serializable;

/**
 * @author varma
 *
 */
public interface IModel extends Serializable {

	/**
	 * @return
	 */
	String getId();

	/**
	 * @param id
	 */
	void setId(String id);

}
