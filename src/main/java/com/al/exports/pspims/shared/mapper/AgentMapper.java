package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Agent;
import com.al.exports.pspims.shared.model.AgentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgentMapper {
    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    @InheritInverseConfiguration
    AgentDTO agentToAgentDTO(Agent agent);

    @Mapping(target = "apiKey", ignore = true)
    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "suppliers", ignore = true)
    Agent agentDtoToAgent(AgentDTO agentDTO);
}
