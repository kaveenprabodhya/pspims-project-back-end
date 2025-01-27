package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.BeverageIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeverageIngredientsRepository extends JpaRepository<BeverageIngredients, UUID> {
}
