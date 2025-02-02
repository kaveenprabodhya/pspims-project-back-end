package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.ProdOrderDetailsService;
import com.al.exports.pspims.shared.model.ProdOrderDetailsDTO;
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
@RequestMapping(ProdOrderDetailsRestController.BASE_URL)
@RequiredArgsConstructor
public class ProdOrderDetailsRestController {
    public static final String BASE_URL = "/api/v1/prodOrderDetails";
    private final ProdOrderDetailsService prodOrderDetailsService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<ProdOrderDetailsDTO>> getAllProdOrderDetails(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                            @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<ProdOrderDetailsDTO> prodOrderDetailsDTOS = prodOrderDetailsService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(prodOrderDetailsDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<ProdOrderDetailsDTO> getProdOrderDetailsById(@PathVariable UUID id) {
        log.info("Fetching prodOrderDetail with ID: {}", id);
        return new ResponseEntity<>(prodOrderDetailsService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<ProdOrderDetailsDTO> createProdOrderDetails(@Valid @RequestBody ProdOrderDetailsDTO prodOrderDetailsDTOS) {
        log.info("Creating prodOrderDetail: {}", prodOrderDetailsDTOS);
        return new ResponseEntity<>(prodOrderDetailsService.create(prodOrderDetailsDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<ProdOrderDetailsDTO> updateProdOrderDetails(@PathVariable UUID id, @Valid @RequestBody ProdOrderDetailsDTO prodOrderDetailsDTOS) {
        log.info("Fully updating prodOrderDetail with ID: {}", id);
        return new ResponseEntity<>(prodOrderDetailsService.update(id, prodOrderDetailsDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<ProdOrderDetailsDTO> patchProdOrderDetails(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ProdOrderDetailsDTO prodOrderDetailsDTOS = objectMapper.convertValue(updates, ProdOrderDetailsDTO.class);
        log.info("Partial updating prodOrderDetail with ID: {}", id);
        return new ResponseEntity<>(prodOrderDetailsService.patch(id, prodOrderDetailsDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteProdOrderDetailsById(@PathVariable UUID id) {
        log.warn("Deleting prodOrderDetail with ID: {}", id);
        prodOrderDetailsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
