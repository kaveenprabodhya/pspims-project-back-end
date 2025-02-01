package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.Order;
import com.al.exports.pspims.repository.OrderRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.*;
import com.al.exports.pspims.shared.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final PaymentDetailsMapper paymentDetailsMapper;
    private final VinegarProdOrderMapper vinegarProdOrderMapper;
    private final BeverageProdOrderMapper beverageProdOrderMapper;
    private final ShippingPlanMapper shippingPlanMapper;
    private final CoconutWaterProdOrderMapper coconutWaterProdOrderMapper;

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        Page<Order> orders = orderRepository.findAll(pageable);
        return orders.map(orderMapper::orderToOrderDTO);
    }

    @Override
    public OrderDTO findById(UUID uuid) {
        return orderRepository
                .findById(uuid)
                .map(orderMapper::orderToOrderDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found order with id: " + uuid));
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return saveAndReturnDTO(orderMapper.orderDtoToOrder(orderDTO));
    }

    @Override
    public OrderDTO update(UUID id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found order with id: " + id));
        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderStatus(order.getOrderStatus());
        order.setCoconutWaterProdOrder(coconutWaterProdOrderMapper.CoconutWaterProdOrderDtoToCoconutWaterProdOrder(orderDTO.getCoconutWaterProdOrder()));
        order.setVinegarProdOrder(vinegarProdOrderMapper.vinegarProdOrderDtoToVinegarProdOrder(orderDTO.getVinegarProdOrder()));
        order.setBeverageProdOrder(beverageProdOrderMapper.beverageProdOrderDtoToBeverageProdOrder(orderDTO.getBeverageProdOrder()));
        order.setPaymentDetails(paymentDetailsMapper.paymentDetailsDtoToPaymentDetails(orderDTO.getPaymentDetails()));
        order.setCustomer(customerMapper.customerDtoToCustomer(orderDTO.getCustomer()));
        order.setShippingPlan(shippingPlanMapper.shippingPlanDtoToShippingPlan(orderDTO.getShippingPlan()));
        return saveAndReturnDTO(order);
    }

    @Override
    public OrderDTO patch(UUID id, OrderDTO orderDTO) {
        return orderRepository.findById(id).map(order -> {
            if (orderDTO.getOrderDate() != null) {
                order.setOrderDate(orderDTO.getOrderDate());
            }
            if (orderDTO.getOrderStatus() != null) {
                order.setOrderStatus(order.getOrderStatus());
            }
            if (orderDTO.getCoconutWaterProdOrder() != null) {
                order.setCoconutWaterProdOrder(coconutWaterProdOrderMapper.CoconutWaterProdOrderDtoToCoconutWaterProdOrder(orderDTO.getCoconutWaterProdOrder()));
            }
            if (orderDTO.getVinegarProdOrder() != null) {
                order.setVinegarProdOrder(vinegarProdOrderMapper.vinegarProdOrderDtoToVinegarProdOrder(orderDTO.getVinegarProdOrder()));
            }
            if (orderDTO.getBeverageProdOrder() != null) {
                order.setBeverageProdOrder(beverageProdOrderMapper.beverageProdOrderDtoToBeverageProdOrder(orderDTO.getBeverageProdOrder()));
            }
            if (orderDTO.getPaymentDetails() != null) {
                order.setPaymentDetails(paymentDetailsMapper.paymentDetailsDtoToPaymentDetails(orderDTO.getPaymentDetails()));
            }
            if (orderDTO.getCustomer() != null) {
                order.setCustomer(customerMapper.customerDtoToCustomer(orderDTO.getCustomer()));
            }
            if (orderDTO.getShippingPlan() != null) {
                order.setShippingPlan(shippingPlanMapper.shippingPlanDtoToShippingPlan(orderDTO.getShippingPlan()));
            }
            return saveAndReturnDTO(order);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found order with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        orderRepository.deleteById(uuid);
    }

    private OrderDTO saveAndReturnDTO(Order order){
        Order returnOrder = orderRepository.save(order);
        return orderMapper.orderToOrderDTO(returnOrder);
    }
}
