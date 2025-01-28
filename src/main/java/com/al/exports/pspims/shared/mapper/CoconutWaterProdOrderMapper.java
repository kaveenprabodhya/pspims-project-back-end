package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.CoconutWaterProdOrder;
import com.al.exports.pspims.shared.model.CoconutWaterProdOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoconutWaterProdOrderMapper {
    CoconutWaterProdOrderMapper INSTANCE = Mappers.getMapper(CoconutWaterProdOrderMapper.class);

    CoconutWaterProdOrderDTO coconutWaterProdOrderToCoconutWaterProdOrderDTO(CoconutWaterProdOrder coconutWaterProdOrder);

    CoconutWaterProdOrder CoconutWaterProdOrderDtoToCoconutWaterProdOrder(CoconutWaterProdOrderDTO coconutWaterProdOrderDTO);
}
