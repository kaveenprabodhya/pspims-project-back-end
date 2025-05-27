package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Customer;
import com.al.exports.pspims.shared.model.CustomerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @InheritInverseConfiguration
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "copraSale", ignore = true)
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
