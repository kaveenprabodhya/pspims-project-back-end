package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.AgentDTO;

import java.util.UUID;

public interface AgentService extends CrudService<AgentDTO, UUID> {
    public AgentDTO findByUsername(String username);

    public AgentDTO update(String token, UUID id);
}
