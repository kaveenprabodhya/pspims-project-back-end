package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.CopraSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CopraSaleRepository extends JpaRepository<CopraSale, UUID> {
}
