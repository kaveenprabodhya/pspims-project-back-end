package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.VinegarProdOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VinegarProdOrderRepository extends JpaRepository<VinegarProdOrder, UUID> {
}
