package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.BeverageProdOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeverageProdOrderRepository extends JpaRepository<BeverageProdOrder, UUID> {
}
