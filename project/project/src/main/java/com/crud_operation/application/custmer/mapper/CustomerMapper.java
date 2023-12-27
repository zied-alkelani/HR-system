package com.crud_operation.application.custmer.mapper;

import com.crud_operation.application.custmer.dto.CustomerDTO;
import com.crud_operation.application.custmer.entitys.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CustomerMapper extends GenericMapper<CustomerEntity, CustomerDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    CustomerEntity asEntity(CustomerDTO dto);
}