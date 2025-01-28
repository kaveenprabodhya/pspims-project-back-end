package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Order;
import com.al.exports.pspims.shared.model.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToOrderDTO(Order order);

    Order orderDtoToOrder(OrderDTO orderDTO);
}
