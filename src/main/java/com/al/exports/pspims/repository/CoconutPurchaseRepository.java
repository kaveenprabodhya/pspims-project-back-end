package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.CoconutPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoconutPurchaseRepository extends JpaRepository<CoconutPurchase, UUID> {
}
