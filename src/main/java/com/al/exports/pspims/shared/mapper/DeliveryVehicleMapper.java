package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.DeliveryVehicle;
import com.al.exports.pspims.shared.model.DeliveryVehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DeliveryVehicleMapper {
    DeliveryVehicleMapper INSTANCE = Mappers.getMapper(DeliveryVehicleMapper.class);

    DeliveryVehicleDTO deliveryVehicleToDeliveryVehicleDTO(DeliveryVehicle deliveryVehicle);

    DeliveryVehicle deliveryVehicleDtoTODeliveryVehicle(DeliveryVehicleDTO deliveryVehicleDTO);
}
