package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.ProdOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdOrderDetailsRepository extends JpaRepository<ProdOrderDetails, UUID> {
}
