package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.CopraSale;
import com.al.exports.pspims.shared.model.CopraSaleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, PaymentDetailsMapper.class, ShippingPlanMapper.class})
public interface CopraSaleMapper {
    CopraSaleMapper INSTANCE = Mappers.getMapper(CopraSaleMapper.class);

    CopraSaleDTO copraSaleToCopraSaleDTO(CopraSale copraSale);

    CopraSale copraSaleDtoToCopraSale(CopraSaleDTO copraSaleDTO);
}
