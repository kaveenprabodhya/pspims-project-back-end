package com.al.exports.pspims.services;

import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.exceptions.UsernameAlreadyTakenException;
import com.al.exports.pspims.shared.model.AgentDTO;
import com.al.exports.pspims.shared.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final AgentUserDetailsService userDetailsService;
    private final AgentService agentService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public String login(String username, String password) {
        AgentDTO agentDTO = agentService.findByUsername(username);

        if (agentDTO == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, agentDTO.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));


        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtUtil.generateToken(userDetails);

        agentService.update(token, agentDTO.getId());

        return token;
    }

    @Transactional
    @Override
    public String signup(AgentDTO agentDTO) {
        try {
            agentService.findByUsername(agentDTO.getUsername());
            throw new UsernameAlreadyTakenException("Username is already taken.");
        } catch (ResourceNotFoundException ignored){
        }
        AgentDTO createdAgentDTO = agentService.create(agentDTO);

        UserDetails userDetails = userDetailsService.loadUserByUsername(createdAgentDTO.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        agentService.update(token, createdAgentDTO.getId());

        return token;
    }
}
