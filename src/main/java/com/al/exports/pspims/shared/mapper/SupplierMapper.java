package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Supplier;
import com.al.exports.pspims.shared.model.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDTO supplierToSupplierDTO(Supplier supplier);

    Supplier supplierDtoToSupplier(SupplierDTO supplierDTO);
}
