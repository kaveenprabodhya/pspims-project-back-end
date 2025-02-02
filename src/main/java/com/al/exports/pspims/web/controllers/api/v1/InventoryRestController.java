package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.InventoryService;
import com.al.exports.pspims.shared.model.InventoryDTO;
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
@RequestMapping(InventoryRestController.BASE_URL)
@RequiredArgsConstructor
public class InventoryRestController {
    public static final String BASE_URL = "/api/v1/inventory";
    private final InventoryService inventoryService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<InventoryDTO>> getAllInventories(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<InventoryDTO> inventoryDTOS = inventoryService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(inventoryDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable UUID id) {
        log.info("Fetching inventory with ID: {}", id);
        return new ResponseEntity<>(inventoryService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@Valid @RequestBody InventoryDTO inventoryDTOS) {
        log.info("Creating inventory: {}", inventoryDTOS);
        return new ResponseEntity<>(inventoryService.create(inventoryDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable UUID id, @Valid @RequestBody InventoryDTO inventoryDTOS) {
        log.info("Fully updating inventory with ID: {}", id);
        return new ResponseEntity<>(inventoryService.update(id, inventoryDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<InventoryDTO> patchInventory(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        InventoryDTO inventoryDTOS = objectMapper.convertValue(updates, InventoryDTO.class);
        log.info("Partial updating inventory with ID: {}", id);
        return new ResponseEntity<>(inventoryService.patch(id, inventoryDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteInventoryById(@PathVariable UUID id) {
        log.warn("Deleting inventory with ID: {}", id);
        inventoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
