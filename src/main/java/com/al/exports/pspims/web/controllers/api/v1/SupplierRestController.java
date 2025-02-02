package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.SupplierService;
import com.al.exports.pspims.shared.model.SupplierDTO;
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
@RequestMapping(SupplierRestController.BASE_URL)
@RequiredArgsConstructor
public class SupplierRestController {
    public static final String BASE_URL = "/api/v1/suppliers";
    private final SupplierService supplierService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<SupplierDTO>> getAllSuppliers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                             @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<SupplierDTO> supplierDTOS = supplierService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(supplierDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable UUID id) {
        log.info("Fetching supplier with ID: {}", id);
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody SupplierDTO supplierDTOS) {
        log.info("Creating supplier: {}", supplierDTOS);
        return new ResponseEntity<>(supplierService.create(supplierDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable UUID id, @Valid @RequestBody SupplierDTO supplierDTOS) {
        log.info("Fully updating supplier with ID: {}", id);
        return new ResponseEntity<>(supplierService.update(id, supplierDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<SupplierDTO> patchSupplier(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SupplierDTO supplierDTOS = objectMapper.convertValue(updates, SupplierDTO.class);
        log.info("Partial updating supplier with ID: {}", id);
        return new ResponseEntity<>(supplierService.patch(id, supplierDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteSupplierById(@PathVariable UUID id) {
        log.warn("Deleting supplier with ID: {}", id);
        supplierService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
