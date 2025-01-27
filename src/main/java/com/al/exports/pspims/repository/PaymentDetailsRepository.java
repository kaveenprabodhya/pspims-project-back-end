package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, UUID> {
}
