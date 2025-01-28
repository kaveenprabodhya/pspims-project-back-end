package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.Agent;
import com.al.exports.pspims.repository.AgentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    @Override
    public Set<Agent> findAll() {
        return Set.of();
    }

    @Override
    public Agent findById(UUID uuid) {
        return null;
    }

    @Override
    public Agent save(Agent object) {
        return null;
    }

    @Override
    public void delete(Agent object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
