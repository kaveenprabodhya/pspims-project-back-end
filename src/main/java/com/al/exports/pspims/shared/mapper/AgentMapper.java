package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Agent;
import com.al.exports.pspims.shared.model.AgentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgentMapper {
    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    AgentDTO agentToAgentDTO(Agent agent);

    Agent agentDtoToAgent(AgentDTO agentDTO);
}
