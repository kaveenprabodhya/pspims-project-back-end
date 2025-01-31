package com.al.exports.pspims.services;

import com.al.exports.pspims.shared.model.AgentDTO;

public interface AuthService {
    public String login(String username, String password);

    public String signup(AgentDTO agentDTO);
}
