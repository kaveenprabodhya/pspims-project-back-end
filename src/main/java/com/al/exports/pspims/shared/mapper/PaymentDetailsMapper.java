package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.PaymentDetails;
import com.al.exports.pspims.shared.model.PaymentDetailsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {
    PaymentDetailsMapper INSTANCE = Mappers.getMapper(PaymentDetailsMapper.class);

    @InheritInverseConfiguration
    PaymentDetailsDTO paymentDetailsToPaymentDetailsDTO(PaymentDetails paymentDetails);

    @Mapping(target = "invoiceNo", ignore = true)
    PaymentDetails paymentDetailsDtoToPaymentDetails(PaymentDetailsDTO paymentDetailsDTO);
}
