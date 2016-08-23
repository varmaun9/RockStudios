/**
 *
 */
package com.rockstudios.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.Roles;
import com.rockstudios.model.RolesModel;

/**
 * @author Jay
 *
 */
@Component("rolesModelToRolesConverter")
public class RolesModelToRolesConverter implements Converter<RolesModel, Roles> {
    @Autowired
    private ObjectFactory<Roles> rolesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Roles convert(final RolesModel source) {
        Roles roles = rolesFactory.getObject();
        BeanUtils.copyProperties(source, roles);

        return roles;
    }

    @Autowired
    public void setRolesFactory(final ObjectFactory<Roles> rolesFactory) {
        this.rolesFactory = rolesFactory;
    }

}
