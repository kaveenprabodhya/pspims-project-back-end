package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.ProdOrderDetails;
import com.al.exports.pspims.shared.model.ProdOrderDetailsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdOrderDetailsMapper {
    ProdOrderDetailsMapper INSTANCE = Mappers.getMapper(ProdOrderDetailsMapper.class);

    @InheritInverseConfiguration
    ProdOrderDetailsDTO prodOrderDetailsToProdOrderDetailsDTO(ProdOrderDetails prodOrderDetails);

    @Mapping(target = "batchNumber", ignore = true)
    ProdOrderDetails prodOrderDetailsDtoToProdOrderDetails(ProdOrderDetailsDTO prodOrderDetailsDTO);
}
