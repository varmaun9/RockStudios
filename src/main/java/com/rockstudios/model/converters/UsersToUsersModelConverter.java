package com.rockstudios.model.converters;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.Users;
import com.rockstudios.model.RolesModel;
import com.rockstudios.model.UsersModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("usersToUsersModelConverter")
public class UsersToUsersModelConverter
        implements Converter<Users, UsersModel> {
    @Autowired
    private ObjectFactory<UsersModel> usersModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersModel convert(final Users source) {
        UsersModel usersModel = usersModelFactory.getObject();
        BeanUtils.copyProperties(source, usersModel);

        if (CollectionUtils.isNotEmpty(source.getRoleses())) {
            List<RolesModel> converted = (List<RolesModel>) conversionService.convert(
                    source.getRoleses(), TypeDescriptor.forObject(source.getRoleses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),RolesModel.class));
            usersModel.getRolesModels().addAll(converted);
        }
        return usersModel;
    }

    @Autowired
    public void setUsersModelFactory(
            final ObjectFactory<UsersModel> usersModelFactory) {
        this.usersModelFactory = usersModelFactory;
    }
}
