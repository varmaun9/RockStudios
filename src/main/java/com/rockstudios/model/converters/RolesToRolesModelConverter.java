package com.rockstudios.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.Roles;
import com.rockstudios.model.RolesModel;

@Component("rolesToRolesModelConverter")
public class RolesToRolesModelConverter
        implements Converter<Roles, RolesModel> {
    @Autowired
    private ObjectFactory<RolesModel> rolesModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public RolesModel convert(final Roles source) {
        RolesModel rolesModel = rolesModelFactory.getObject();
        BeanUtils.copyProperties(source, rolesModel);

        return rolesModel;
    }

    @Autowired
    public void setRolesModelFactory(
            final ObjectFactory<RolesModel> rolesModelFactory) {
        this.rolesModelFactory = rolesModelFactory;
    }
}
