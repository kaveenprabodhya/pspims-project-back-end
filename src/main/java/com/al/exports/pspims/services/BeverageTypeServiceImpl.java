package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.BeverageType;
import com.al.exports.pspims.repository.BeverageTypeRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.BeverageIngredientsMapper;
import com.al.exports.pspims.shared.mapper.BeverageTypeMapper;
import com.al.exports.pspims.shared.model.BeverageTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeverageTypeServiceImpl implements BeverageTypeService {

    private final BeverageTypeRepository beverageTypeRepository;
    private final BeverageTypeMapper beverageTypeMapper;
    private final BeverageIngredientsMapper beverageIngredientsMapper;

    @Override
    public Page<BeverageTypeDTO> findAll(Pageable pageable) {
        Page<BeverageType> beverageTypes = beverageTypeRepository
                .findAll(pageable);
        return beverageTypes.map(beverageTypeMapper::BeverageTypeToBeverageTypeDTO);
    }

    @Override
    public BeverageTypeDTO findById(UUID uuid) {
        return beverageTypeRepository
                .findById(uuid)
                .map(beverageTypeMapper::BeverageTypeToBeverageTypeDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found beverage type with id: " + uuid));
    }

    @Override
    public BeverageTypeDTO create(BeverageTypeDTO beverageTypeDTO) {
        return saveAndReturnDTO(beverageTypeMapper.BeverageTypeDtotoBeverageType(beverageTypeDTO));
    }

    @Override
    public BeverageTypeDTO update(UUID id, BeverageTypeDTO beverageTypeDTO) {
        BeverageType beverageType = beverageTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found beverage type with id: " + id));
        beverageType.setBeverageName(beverageTypeDTO.getBeverageName());
        beverageType.setBeverageDescription(beverageTypeDTO.getBeverageDescription());
        beverageType.setIsActive(beverageTypeDTO.getIsActive());
        return saveAndReturnDTO(beverageType);
    }

    @Override
    public BeverageTypeDTO patch(UUID id, BeverageTypeDTO beverageTypeDTO) {
        return beverageTypeRepository.findById(id).map(beverageType -> {
            if(beverageTypeDTO.getBeverageName() != null){
                beverageType.setBeverageName(beverageTypeDTO.getBeverageName());
            }
            if(beverageTypeDTO.getBeverageDescription() != null){
                beverageType.setBeverageDescription(beverageTypeDTO.getBeverageDescription());
            }
            if(beverageTypeDTO.getIsActive() != null){
                beverageType.setIsActive(beverageTypeDTO.getIsActive());
            }
            return saveAndReturnDTO(beverageType);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found beverage type with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        beverageTypeRepository.deleteById(uuid);
    }

    private BeverageTypeDTO saveAndReturnDTO(BeverageType beverageType){
        BeverageType returnBeverageType = beverageTypeRepository.save(beverageType);
        return beverageTypeMapper.BeverageTypeToBeverageTypeDTO(returnBeverageType);
    }
}
