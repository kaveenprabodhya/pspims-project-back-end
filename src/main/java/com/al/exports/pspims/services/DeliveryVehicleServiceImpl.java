package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.DeliveryVehicle;
import com.al.exports.pspims.repository.DeliveryVehicleRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.DeliveryVehicleMapper;
import com.al.exports.pspims.shared.model.DeliveryVehicleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryVehicleServiceImpl implements DeliveryVehicleService {

    private final DeliveryVehicleRepository deliveryVehicleRepository;
    private final DeliveryVehicleMapper deliveryVehicleMapper;

    @Override
    public Page<DeliveryVehicleDTO> findAll(Pageable pageable) {
        Page<DeliveryVehicle> deliveryVehicles = deliveryVehicleRepository.findAll(pageable);
        return deliveryVehicles.map(deliveryVehicleMapper::deliveryVehicleToDeliveryVehicleDTO);
    }

    @Override
    public DeliveryVehicleDTO findById(UUID uuid) {
        return deliveryVehicleRepository
                .findById(uuid)
                .map(deliveryVehicleMapper::deliveryVehicleToDeliveryVehicleDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found delivery vehicle with id: " + uuid));
    }

    @Override
    public DeliveryVehicleDTO create(DeliveryVehicleDTO deliveryVehicleDTO) {
        return saveAndReturnDTO(deliveryVehicleMapper.deliveryVehicleDtoTODeliveryVehicle(deliveryVehicleDTO));
    }

    @Override
    public DeliveryVehicleDTO update(UUID id, DeliveryVehicleDTO deliveryVehicleDTO) {
        DeliveryVehicle deliveryVehicle = deliveryVehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found delivery vehicle with id: " + id));
        deliveryVehicle.setVehicleRegNo(deliveryVehicleDTO.getVehicleRegNo());
        deliveryVehicle.setVehicleType(deliveryVehicleDTO.getVehicleType());
        deliveryVehicle.setAvailabilityStatus(deliveryVehicleDTO.getAvailabilityStatus());
        return saveAndReturnDTO(deliveryVehicle);
    }

    @Override
    public DeliveryVehicleDTO patch(UUID id, DeliveryVehicleDTO deliveryVehicleDTO) {
        return deliveryVehicleRepository.findById(id).map(deliveryVehicle -> {
            if(deliveryVehicleDTO.getVehicleRegNo() != null){
                deliveryVehicle.setVehicleRegNo(deliveryVehicleDTO.getVehicleRegNo());
            }
            if(deliveryVehicleDTO.getVehicleType() != null){
                deliveryVehicle.setVehicleType(deliveryVehicleDTO.getVehicleType());
            }
            if(deliveryVehicleDTO.getAvailabilityStatus() != null){
                deliveryVehicle.setAvailabilityStatus(deliveryVehicleDTO.getAvailabilityStatus());
            }
            return saveAndReturnDTO(deliveryVehicle);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found delivery vehicle with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        deliveryVehicleRepository.deleteById(uuid);
    }

    private DeliveryVehicleDTO saveAndReturnDTO(DeliveryVehicle deliveryVehicle){
        DeliveryVehicle returnDeliveryVehicle = deliveryVehicleRepository.save(deliveryVehicle);
        return deliveryVehicleMapper.deliveryVehicleToDeliveryVehicleDTO(returnDeliveryVehicle);
    }
}
