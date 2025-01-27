package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.SupplierPaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierPaymentDetailsRepository extends JpaRepository<SupplierPaymentDetails, UUID> {
}
