/**
 *
 */
package com.rockstudios.businessdelegate.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("simpleIdKeyBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SimpleIdKeyBuilder implements IKeyBuilder<String> {
	private String id;
	

	/**
	 * {@inheritDoc}
	 *
	 * @see com.cscinfo.businessdelegate.domain.IKeyBuilder#build()
	 */
	@Override
	public String build() {
		return id;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public SimpleIdKeyBuilder withId(final String id) {
		this.id = id;
		return this;
	}

}
