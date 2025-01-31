package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.Agent;
import com.al.exports.pspims.repository.AgentRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.AgentMapper;
import com.al.exports.pspims.shared.model.AgentDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;

    @Override
    public Page<AgentDTO> findAll(Pageable pageable) {
        Page<Agent> agentPage = agentRepository.findAll(pageable);
        return agentPage
                .map(agentMapper::agentToAgentDTO);
    }

    @Override
    public AgentDTO findById(UUID uuid) {
        return agentRepository
                .findById(uuid)
                .map(agentMapper::agentToAgentDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: "+uuid));
    }

    @Override
    public AgentDTO findByUsername(String username){
        return agentRepository
                .findByUsername(username)
                .map(agentMapper::agentToAgentDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with username: "+username));
    }

    private AgentDTO saveAndReturnDTO(Agent agent){
        Agent savedAgent = agentRepository.save(agent);
        return agentMapper.agentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDTO create(AgentDTO agentDTO) {
        return saveAndReturnDTO(agentMapper.agentDtoToAgent(agentDTO));
    }

    @Override
    public AgentDTO update(UUID id, AgentDTO agentDTO) {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));

        existingAgent.setFirstName(agentDTO.getFirstName());
        existingAgent.setLastName(agentDTO.getLastName());
        existingAgent.setEmail(agentDTO.getEmail());
        existingAgent.setAddress(agentDTO.getAddress());
        existingAgent.setAgentDepartment(agentDTO.getAgentDepartment());
        existingAgent.setPerformanceRate(agentDTO.getPerformanceRate());

        return saveAndReturnDTO(existingAgent);
    }

    @Override
    public AgentDTO update(String token, UUID id){
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));
        if(!token.isEmpty()){
            agent.setApiKey(token);
        }
        return saveAndReturnDTO(agent);
    }

    @Override
    public AgentDTO patch(UUID id, AgentDTO agentDTO) {
        return agentRepository.findById(id)
                .map(agent -> {
                    if(agentDTO.getFirstName() != null) {
                        agent.setFirstName(agentDTO.getFirstName());
                    }
                    if(agentDTO.getLastName() != null){
                        agent.setLastName(agentDTO.getLastName());
                    }
                    if(agentDTO.getEmail() != null){
                        agent.setEmail(agentDTO.getEmail());
                    }
                    if(agentDTO.getAddress() != null){
                        agent.setAddress(agentDTO.getAddress());
                    }
                    if(agentDTO.getAgentDepartment() != null){
                        agent.setAgentDepartment(agentDTO.getAgentDepartment());
                    }
                    if(agentDTO.getPerformanceRate() != null){
                        agent.setPerformanceRate(agentDTO.getPerformanceRate());
                    }
                    return saveAndReturnDTO(agent);
                }).orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        agentRepository.deleteById(uuid);
    }
}
