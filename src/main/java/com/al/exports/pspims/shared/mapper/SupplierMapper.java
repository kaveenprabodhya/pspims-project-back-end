package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Supplier;
import com.al.exports.pspims.shared.model.SupplierDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    @InheritInverseConfiguration
    SupplierDTO supplierToSupplierDTO(Supplier supplier);

    @Mapping(target = "supplierPaymentDetails", ignore = true)
    @Mapping(target = "coconutPurchase", ignore = true)
    Supplier supplierDtoToSupplier(SupplierDTO supplierDTO);
}
