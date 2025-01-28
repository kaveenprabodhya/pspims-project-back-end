package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.ProdOrderDetails;
import com.al.exports.pspims.shared.model.ProdOrderDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdOrderDetailsMapper {
    ProdOrderDetailsMapper INSTANCE = Mappers.getMapper(ProdOrderDetailsMapper.class);

    ProdOrderDetailsDTO prodOrderDetailsToProdOrderDetailsDTO(ProdOrderDetails prodOrderDetails);

    ProdOrderDetails prodOrderDetailsDtoToProdOrderDetails(ProdOrderDetailsDTO prodOrderDetailsDTO);
}
