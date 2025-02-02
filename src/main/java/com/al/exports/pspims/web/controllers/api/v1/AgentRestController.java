package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.AgentService;
import com.al.exports.pspims.shared.model.AgentDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//public record PagedResponse<T>(List<T> content, int pageNumber, int pageSize, long totalElements, int totalPages) {}

@Slf4j
@RestController
@RequestMapping(AgentRestController.BASE_URL)
@RequiredArgsConstructor
public class AgentRestController {
    public static final String BASE_URL = "/api/v1/agents";
    private final AgentService agentService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<Page<AgentDTO>> getAllAgents(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                            @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<AgentDTO> agentDTOS = agentService.findAll(PageRequest.of(pageNumber, pageSize));

//        For log error Serializing PageImpl instances as-is is not supported.
//        PagedResponse<AgentDTO> response = new PagedResponse<>(
//                agentDTOS.getContent(),
//                agentDTOS.getNumber(),
//                agentDTOS.getSize(),
//                agentDTOS.getTotalElements(),
//                agentDTOS.getTotalPages()
//        );

        return new ResponseEntity<>(agentDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<AgentDTO> getAgentById(@PathVariable UUID id){
        log.info("Fetching agent with ID: {}", id);
        return new ResponseEntity<>(agentService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping("/byUsername")
    public ResponseEntity<AgentDTO> getAgentByUsername(@RequestParam(value = "username") String username){
        log.info("Fetching agent by Username: {}", username);
        return new ResponseEntity<>(agentService.findByUsername(username), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<AgentDTO> createAgent(@Valid @RequestBody AgentDTO agentDTO){
        log.info("Creating agent: {}", agentDTO);
        return new ResponseEntity<>(agentService.create(agentDTO), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<AgentDTO> updateAgent(@PathVariable UUID id, @Valid @RequestBody AgentDTO agentDTO){
        log.info("Fully updating agent with ID: {}", id);
        return new ResponseEntity<>(agentService.update(id, agentDTO), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<AgentDTO> patchAgent(@PathVariable UUID id, @Valid @RequestBody Object updates){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        AgentDTO agentDTO = objectMapper.convertValue(updates, AgentDTO.class);
        log.info("Partial updating agent with ID: {}", id);
        return new ResponseEntity<>(agentService.patch(id, agentDTO), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteAgentById(@PathVariable UUID id){
        log.warn("Deleting agent with ID: {}", id);
        agentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
