package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.CopraSaleService;
import com.al.exports.pspims.shared.model.CopraSaleDTO;
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

@Slf4j
@RestController
@RequestMapping(CopraSaleRestController.BASE_URL)
@RequiredArgsConstructor
public class CopraSaleRestController {
    public static final String BASE_URL = "/api/v1/copraSales";
    private final CopraSaleService copraSaleService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<CopraSaleDTO>> getAllCopraSales(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                               @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<CopraSaleDTO> copraSaleDTOS = copraSaleService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(copraSaleDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<CopraSaleDTO> getCopraSaleById(@PathVariable UUID id) {
        log.info("Fetching copraSale with ID: {}", id);
        return new ResponseEntity<>(copraSaleService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<CopraSaleDTO> createCopraSale(@Valid @RequestBody CopraSaleDTO copraSaleDTOS) {
        log.info("Creating copraSale: {}", copraSaleDTOS);
        return new ResponseEntity<>(copraSaleService.create(copraSaleDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<CopraSaleDTO> updateCopraSale(@PathVariable UUID id, @Valid @RequestBody CopraSaleDTO copraSaleDTOS) {
        log.info("Fully updating copraSale with ID: {}", id);
        return new ResponseEntity<>(copraSaleService.update(id, copraSaleDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<CopraSaleDTO> patchCopraSale(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CopraSaleDTO copraSaleDTOS = objectMapper.convertValue(updates, CopraSaleDTO.class);
        log.info("Partial updating copraSale with ID: {}", id);
        return new ResponseEntity<>(copraSaleService.patch(id, copraSaleDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCopraSaleById(@PathVariable UUID id) {
        log.warn("Deleting copraSale with ID: {}", id);
        copraSaleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
