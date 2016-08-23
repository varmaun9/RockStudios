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

import com.rockstudios.domain.OrganisationBranch;
import com.rockstudios.model.CourseModel;
import com.rockstudios.model.OrganisationBranchModel;
import com.rockstudios.util.CollectionTypeDescriptor;

@Component("organisationBranchToOrganisationBranchModelConverter")
public class OrganisationBranchToOrganisationBranchModelConverter
        implements Converter<OrganisationBranch, OrganisationBranchModel> {
    @Autowired
    private ObjectFactory<OrganisationBranchModel> organisationBranchModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OrganisationBranchModel convert(final OrganisationBranch source) {
        OrganisationBranchModel organisationBranchModel = organisationBranchModelFactory.getObject();
        BeanUtils.copyProperties(source, organisationBranchModel);

        if (CollectionUtils.isNotEmpty(source.getCourses())) {
            List<CourseModel> converted = (List<CourseModel>) conversionService.convert(
                    source.getCourses(), TypeDescriptor.forObject(source.getCourses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class),CourseModel.class));
            organisationBranchModel.getCourseModels().addAll(converted);
        }
        
        return organisationBranchModel;
    }

    @Autowired
    public void setOrganisationBranchModelFactory(
            final ObjectFactory<OrganisationBranchModel> organisationBranchModelFactory) {
        this.organisationBranchModelFactory = organisationBranchModelFactory;
    }
}
