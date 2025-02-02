package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.BeverageIngredients;
import com.al.exports.pspims.repository.BeverageIngredientsRepository;
import com.al.exports.pspims.repository.BeverageTypeRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.BeverageIngredientsMapper;
import com.al.exports.pspims.shared.mapper.BeverageTypeMapper;
import com.al.exports.pspims.shared.model.BeverageIngredientsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeverageIngredientsServiceImpl implements BeverageIngredientsService {

    private final BeverageIngredientsRepository beverageIngredientsRepository;
    private final BeverageIngredientsMapper beverageIngredientsMapper;
    private final BeverageTypeMapper beverageTypeMapper;
    private final BeverageTypeRepository beverageTypeRepository;

    @Override
    public Page<BeverageIngredientsDTO> findAll(Pageable pageable) {
        Page<BeverageIngredients> beverageIngredients = beverageIngredientsRepository.findAll(pageable);
        return beverageIngredients.
                map(beverageIngredientsMapper::beverageIngredientsToBeverageIngredientsDTO);
    }

    @Override
    public BeverageIngredientsDTO findById(UUID uuid) {
        return beverageIngredientsRepository
                .findById(uuid)
                .map(beverageIngredientsMapper::beverageIngredientsToBeverageIngredientsDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found beverage ingredients with id: "+ uuid));
    }

    @Override
    public BeverageIngredientsDTO create(BeverageIngredientsDTO beverageIngredientsDTO) {
        BeverageIngredients beverageIngredients =
                beverageIngredientsMapper.beverageIngredientsDtoToBeverageIngredients(beverageIngredientsDTO);
        return saveAndReturnDTO(beverageIngredients);
    }

    @Override
    public BeverageIngredientsDTO update(UUID id, BeverageIngredientsDTO beverageIngredientsDTO) {
        Optional<BeverageIngredients> existingBeverageIngredient = beverageIngredientsRepository.findById(id);
        if(existingBeverageIngredient.isPresent()) {
            BeverageIngredients beverageIngredients = existingBeverageIngredient.get();
            beverageIngredients.setIngredientName(beverageIngredientsDTO.getIngredientName());
            beverageIngredients.setIngredientMeasure(beverageIngredientsDTO.getIngredientMeasure());
            beverageIngredients.setMeasureAmount(beverageIngredientsDTO.getMeasureAmount());
            beverageIngredients.setBeverageType(beverageTypeMapper.BeverageTypeDtotoBeverageType(beverageIngredientsDTO.getBeverageType()));
            return saveAndReturnDTO(beverageIngredients);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found beverage ingredients with id: " + id);
        }
    }

    @Override
    public BeverageIngredientsDTO patch(UUID id, BeverageIngredientsDTO beverageIngredientsDTO) {
        return beverageIngredientsRepository.findById(id)
                .map(beverageIngredients -> {
                    if(beverageIngredientsDTO.getIngredientName() != null){
                        beverageIngredients.setIngredientName(beverageIngredientsDTO.getIngredientName());
                    }
                    if(beverageIngredientsDTO.getIngredientMeasure() != null){
                        beverageIngredients.setIngredientMeasure(beverageIngredientsDTO.getIngredientMeasure());
                    }
                    if(beverageIngredientsDTO.getMeasureAmount() != null){
                        beverageIngredients.setMeasureAmount(beverageIngredientsDTO.getMeasureAmount());
                    }
                    if(beverageIngredientsDTO.getBeverageType() != null){
                        beverageIngredients.setBeverageType(beverageTypeMapper.BeverageTypeDtotoBeverageType(beverageIngredientsDTO.getBeverageType()));
                    }
                    return saveAndReturnDTO(beverageIngredients);
                }).orElseThrow(() -> new ResourceNotFoundException("Not found beverage ingredients with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        beverageIngredientsRepository.deleteById(uuid);
    }

    private BeverageIngredientsDTO saveAndReturnDTO(BeverageIngredients beverageIngredients){
        BeverageIngredients savedBeverageIngredients = beverageIngredientsRepository.save(beverageIngredients);
        return beverageIngredientsMapper.beverageIngredientsToBeverageIngredientsDTO(savedBeverageIngredients);
    }
}
