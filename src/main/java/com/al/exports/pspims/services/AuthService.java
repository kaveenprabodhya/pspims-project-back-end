package com.al.exports.pspims.services;

import com.al.exports.pspims.shared.model.AgentDTO;
import com.al.exports.pspims.shared.model.AuthDTO;

public interface AuthService {
    public AuthDTO login(String username, String password);

    public AuthDTO signup(AgentDTO agentDTO);
}
