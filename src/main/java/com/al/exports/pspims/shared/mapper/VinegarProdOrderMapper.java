package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.VinegarProdOrder;
import com.al.exports.pspims.shared.model.VinegarProdOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VinegarProdOrderMapper {
    VinegarProdOrderMapper INSTANCE = Mappers.getMapper(VinegarProdOrderMapper.class);

    VinegarProdOrderDTO vinegarProdOrderToVinegarProdOrderDTO(VinegarProdOrder vinegarProdOrder);

    VinegarProdOrder vinegarProdOrderDtoToVinegarProdOrder(VinegarProdOrderDTO vinegarProdOrderDTO);
}
