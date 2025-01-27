package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.CoconutWaterProdOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoconutWaterProdOrderRepository extends JpaRepository<CoconutWaterProdOrder, UUID> {
}
