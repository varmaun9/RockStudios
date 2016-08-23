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

import com.rockstudios.domain.Organisation;
import com.rockstudios.model.OrganisationBranchModel;
import com.rockstudios.model.OrganisationModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("organisationToOrganisationModelConverter")
public class OrganisationToOrganisationModelConverter
        implements Converter<Organisation, OrganisationModel> {
    @Autowired
    private ObjectFactory<OrganisationModel> organisationModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OrganisationModel convert(final Organisation source) {
        OrganisationModel organisationModel = organisationModelFactory.getObject();
        BeanUtils.copyProperties(source, organisationModel);

        if (CollectionUtils.isNotEmpty(source.getOrganisationBranches())) {
            List<OrganisationBranchModel> converted = (List<OrganisationBranchModel>) conversionService.convert(
                    source.getOrganisationBranches(), TypeDescriptor.forObject(source.getOrganisationBranches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),OrganisationBranchModel.class));
            organisationModel.getOrganisationBranchModel().addAll(converted);
        }
        return organisationModel;
    }

    @Autowired
    public void setOrganisationModelFactory(
            final ObjectFactory<OrganisationModel> organisationModelFactory) {
        this.organisationModelFactory = organisationModelFactory;
    }
}
