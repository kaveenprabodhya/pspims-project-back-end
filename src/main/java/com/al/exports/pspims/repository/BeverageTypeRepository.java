package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.BeverageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeverageTypeRepository extends JpaRepository<BeverageType, UUID> {
}
