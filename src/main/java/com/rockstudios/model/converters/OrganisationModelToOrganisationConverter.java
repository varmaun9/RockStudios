/**
 *
 */
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
import com.rockstudios.domain.OrganisationBranch;
import com.rockstudios.model.OrganisationModel;
import com.rockstudios.util.CollectionTypeDescriptor;

/**
 * @author Jay
 *
 */
@Component("organisationModelToOrganisationConverter")
public class OrganisationModelToOrganisationConverter implements Converter<OrganisationModel, Organisation> {
    @Autowired
    private ObjectFactory<Organisation> organisationFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Organisation convert(final OrganisationModel source) {
        Organisation organisation = organisationFactory.getObject();
        BeanUtils.copyProperties(source, organisation);
        
        if (CollectionUtils.isNotEmpty(source.getOrganisationBranchModel())) {
            List<OrganisationBranch> converted = (List<OrganisationBranch>) conversionService.convert(
                    source.getOrganisationBranchModel(), TypeDescriptor.forObject(source.getOrganisationBranchModel()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),OrganisationBranch.class));
            organisation.getOrganisationBranches().addAll(converted);
        }
        
        return organisation;
    }

    @Autowired
    public void setOrganisationFactory(final ObjectFactory<Organisation> organisationFactory) {
        this.organisationFactory = organisationFactory;
    }

}
