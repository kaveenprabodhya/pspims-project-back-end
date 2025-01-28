package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.BeverageIngredients;

import java.util.Set;
import java.util.UUID;

public class BeverageIngredientsServiceImpl implements BeverageIngredientsService {
    @Override
    public Set<BeverageIngredients> findAll() {
        return Set.of();
    }

    @Override
    public BeverageIngredients findById(UUID uuid) {
        return null;
    }

    @Override
    public BeverageIngredients save(BeverageIngredients object) {
        return null;
    }

    @Override
    public void delete(BeverageIngredients object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
