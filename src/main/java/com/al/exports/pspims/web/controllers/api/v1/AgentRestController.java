package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.AgentService;
import com.al.exports.pspims.shared.model.AgentDTO;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AgentRestController.BASE_URL)
@RequiredArgsConstructor
public class AgentRestController {
    public static final String BASE_URL = "/api/v1/agent";
    private final AgentService agentService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

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
        return new ResponseEntity<>(agentDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<AgentDTO> getAgentById(@PathVariable UUID id){
        return new ResponseEntity<>(agentService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgentDTO> createAgent(@RequestBody AgentDTO agentDTO){
        return new ResponseEntity<>(agentService.create(agentDTO), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<AgentDTO> updateAgent(@PathVariable UUID id, @RequestBody AgentDTO agentDTO){
        return new ResponseEntity<>(agentService.update(id, agentDTO), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<AgentDTO> patchAgent(@PathVariable UUID id, @RequestBody AgentDTO agentDTO){
        return new ResponseEntity<>(agentService.patch(id, agentDTO), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteAgentById(@PathVariable UUID id){
        agentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<List<String>> badRequestHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath().toString() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
