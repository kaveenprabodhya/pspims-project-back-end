package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.AuthService;
import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import com.al.exports.pspims.shared.enums.Role;
import com.al.exports.pspims.shared.model.AgentDTO;
import com.al.exports.pspims.shared.model.AuthDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AuthController.BASE_URL)
public class AuthController {
    private final AuthService authenticationService;
    public static final String BASE_URL = "/api/v1/auth";

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestParam String username, @RequestParam String password) {
        AuthDTO token = authenticationService.login(username, password);
        return ResponseEntity.ok(token);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/signup")
    public ResponseEntity<AuthDTO> signup(@RequestParam String username, @RequestParam String password,
                                         @RequestParam String firstName, @RequestParam String lastName,
                                         @Valid @RequestParam String email, @RequestParam String address,
                                         @RequestParam Role role, @RequestParam AgentDepartmentTypeEnum agentDepartmentType) {

        AgentDTO agentDTO = new AgentDTO();

        agentDTO.setUsername(username);
        agentDTO.setPassword(password);
        agentDTO.setFirstName(firstName);
        agentDTO.setLastName(lastName);
        agentDTO.setEmail(email);
        agentDTO.setAddress(address);
        agentDTO.setRole(role);
        agentDTO.setAgentDepartment(agentDepartmentType);

        AuthDTO token = authenticationService.signup(agentDTO);

        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }
}
