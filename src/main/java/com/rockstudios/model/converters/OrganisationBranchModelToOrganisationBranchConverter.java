/**
 *
 */
package com.rockstudios.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rockstudios.domain.Organisation;
import com.rockstudios.domain.OrganisationBranch;
import com.rockstudios.model.OrganisationBranchModel;

/**
 * @author Jay
 *
 */
@Component("organisationBranchModelToOrganisationBranchConverter")
public class OrganisationBranchModelToOrganisationBranchConverter implements Converter<OrganisationBranchModel, OrganisationBranch> {
    @Autowired
    private ObjectFactory<OrganisationBranch> organisationBranchFactory;
   /* @Autowired
    private ConversionService conversionService;*/

    @Override
    public OrganisationBranch convert(final OrganisationBranchModel source) {
        OrganisationBranch organisationBranch = organisationBranchFactory.getObject();
        BeanUtils.copyProperties(source, organisationBranch);
        Organisation org = new Organisation();
        org.setId(source.getOrganisationId());
        organisationBranch.setOrganisation(org);
        return organisationBranch;
    }

    @Autowired
    public void setOrganisationBranchFactory(final ObjectFactory<OrganisationBranch> organisationBranchFactory) {
        this.organisationBranchFactory = organisationBranchFactory;
    }

}
