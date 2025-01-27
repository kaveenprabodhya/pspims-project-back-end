package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgentRepository extends JpaRepository<Agent, UUID> {
}
