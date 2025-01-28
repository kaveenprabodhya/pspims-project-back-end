package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.BeverageProdOrder;
import com.al.exports.pspims.shared.model.BeverageProdOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BeverageProdOrderMapper {
    BeverageProdOrderMapper INSTANCE = Mappers.getMapper(BeverageProdOrderMapper.class);

    BeverageProdOrderDTO beverageProdOrderToBeverageProdOrderDTO(BeverageProdOrder beverageProdOrder);

    BeverageProdOrder beverageProdOrderDtoToBeverageProdOrder(BeverageProdOrderDTO beverageProdOrderDTO);
}
