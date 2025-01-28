package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.SupplierPaymentDetails;
import com.al.exports.pspims.shared.model.SupplierPaymentDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierPaymentDetailsMapper {
    SupplierPaymentDetailsMapper INSTANCE = Mappers.getMapper(SupplierPaymentDetailsMapper.class);

    SupplierPaymentDetailsDTO supplierPaymentDetailsToSupplierPaymentDetailsDTO(SupplierPaymentDetails supplierPaymentDetails);

    SupplierPaymentDetails supplierPaymentDetailsDtoToSupplierPaymentDetails(SupplierPaymentDetailsDTO supplierPaymentDetailsDTO);
}
