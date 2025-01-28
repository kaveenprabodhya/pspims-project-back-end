package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.ShippingPlan;
import com.al.exports.pspims.shared.model.ShippingPlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShippingPlanMapper {
    ShippingPlanMapper INSTANCE = Mappers.getMapper(ShippingPlanMapper.class);

    ShippingPlanDTO shippingPlanToShippingPlanDTO(ShippingPlan shippingPlan);

    ShippingPlan shippingPlanDtoToShippingPlan(ShippingPlanDTO shippingPlanDTO);
}
