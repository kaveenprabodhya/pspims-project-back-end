package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.CoconutPurchase;
import com.al.exports.pspims.shared.model.CoconutPurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoconutPurchaseMapper {
    CoconutPurchaseMapper INSTANCE = Mappers.getMapper(CoconutPurchaseMapper.class);

    CoconutPurchaseDTO coconutPurchaseToCoconutPurchaseDTO(CoconutPurchase coconutPurchase);

    CoconutPurchase CoconutPurchaseDtoToCoconutPurchase(CoconutPurchaseDTO coconutPurchaseDTO);
}
