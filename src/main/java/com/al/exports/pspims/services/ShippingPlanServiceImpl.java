package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.ShippingPlan;
import com.al.exports.pspims.repository.ShippingPlanRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.DeliveryVehicleMapper;
import com.al.exports.pspims.shared.mapper.ShippingPlanMapper;
import com.al.exports.pspims.shared.model.ShippingPlanDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShippingPlanServiceImpl implements ShippingPlanService {

    private final ShippingPlanRepository shippingPlanRepository;
    private final ShippingPlanMapper shippingPlanMapper;
    private final DeliveryVehicleMapper deliveryVehicleMapper;

    @Override
    public Page<ShippingPlanDTO> findAll(Pageable pageable) {
        Page<ShippingPlan> shippingPlans = shippingPlanRepository.findAll(pageable);
        return shippingPlans.map(shippingPlanMapper::shippingPlanToShippingPlanDTO);
    }

    @Override
    public ShippingPlanDTO findById(UUID uuid) {
        return shippingPlanRepository
                .findById(uuid)
                .map(shippingPlanMapper::shippingPlanToShippingPlanDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found shipping plan with id: " + uuid));
    }

    @Override
    public ShippingPlanDTO create(ShippingPlanDTO shippingPlanDTO) {
        return saveAndReturnDTO(shippingPlanMapper.shippingPlanDtoToShippingPlan(shippingPlanDTO));
    }

    @Override
    public ShippingPlanDTO update(UUID id, ShippingPlanDTO shippingPlanDTO) {
        ShippingPlan shippingPlan = shippingPlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found shipping plan with id: " + id));
        shippingPlan.setShippingAddress(shippingPlanDTO.getShippingAddress());
        shippingPlan.setShippingDate(shippingPlanDTO.getShippingDate());
        shippingPlan.setShippingType(shippingPlanDTO.getShippingType());
        shippingPlan.setTrackingNumber(shippingPlanDTO.getTrackingNumber());
        shippingPlan.setShippingStatus(shippingPlanDTO.getShippingStatus());
        shippingPlan.setDeliveryType(shippingPlanDTO.getDeliveryType());
        shippingPlan.setDeliveryVehicle(deliveryVehicleMapper.deliveryVehicleDtoTODeliveryVehicle(shippingPlanDTO.getDeliveryVehicle()));
        return saveAndReturnDTO(shippingPlan);
    }

    @Override
    public ShippingPlanDTO patch(UUID id, ShippingPlanDTO shippingPlanDTO) {
        return shippingPlanRepository.findById(id).map(shippingPlan -> {
            if (shippingPlanDTO.getShippingAddress() != null) {
                shippingPlan.setShippingAddress(shippingPlanDTO.getShippingAddress());
            }
            if (shippingPlanDTO.getShippingDate() != null) {
                shippingPlan.setShippingDate(shippingPlanDTO.getShippingDate());
            }
            if (shippingPlanDTO.getShippingType() != null) {
                shippingPlan.setShippingType(shippingPlanDTO.getShippingType());
            }
            if (shippingPlanDTO.getTrackingNumber() != null) {
                shippingPlan.setTrackingNumber(shippingPlanDTO.getTrackingNumber());
            }
            if (shippingPlanDTO.getShippingStatus() != null) {
                shippingPlan.setShippingStatus(shippingPlanDTO.getShippingStatus());
            }
            if (shippingPlanDTO.getDeliveryType() != null) {
                shippingPlan.setDeliveryType(shippingPlanDTO.getDeliveryType());
            }
            if (shippingPlanDTO.getDeliveryVehicle() != null) {
                shippingPlan.setDeliveryVehicle(deliveryVehicleMapper.deliveryVehicleDtoTODeliveryVehicle(shippingPlanDTO.getDeliveryVehicle()));
            }
            return saveAndReturnDTO(shippingPlan);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found shipping plan with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        shippingPlanRepository.deleteById(uuid);
    }

    private ShippingPlanDTO saveAndReturnDTO(ShippingPlan shippingPlan) {
        ShippingPlan returnShippingPlan = shippingPlanRepository.save(shippingPlan);
        return shippingPlanMapper.shippingPlanToShippingPlanDTO(returnShippingPlan);
    }
}
