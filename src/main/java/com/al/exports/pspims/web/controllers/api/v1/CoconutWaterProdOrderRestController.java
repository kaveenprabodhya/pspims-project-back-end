package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.CoconutWaterProdOrderService;
import com.al.exports.pspims.shared.model.CoconutWaterProdOrderDTO;
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
@RequestMapping(CoconutWaterProdOrderRestController.BASE_URL)
@RequiredArgsConstructor
public class CoconutWaterProdOrderRestController {
    public static final String BASE_URL = "/api/v1/coconutWaterProdOrders";
    private final CoconutWaterProdOrderService coconutWaterProdOrderService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<CoconutWaterProdOrderDTO>> getAllCoconutWaterProdOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                                       @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<CoconutWaterProdOrderDTO> coconutWaterProdOrderDTOS = coconutWaterProdOrderService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(coconutWaterProdOrderDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<CoconutWaterProdOrderDTO> getCoconutWaterProdOrderById(@PathVariable UUID id) {
        log.info("Fetching coconutWaterProdOrder with ID: {}", id);
        return new ResponseEntity<>(coconutWaterProdOrderService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<CoconutWaterProdOrderDTO> createCoconutWaterProdOrder(@Valid @RequestBody CoconutWaterProdOrderDTO coconutWaterProdOrderDTOS) {
        log.info("Creating coconutWaterProdOrder: {}", coconutWaterProdOrderDTOS);
        return new ResponseEntity<>(coconutWaterProdOrderService.create(coconutWaterProdOrderDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<CoconutWaterProdOrderDTO> updateCoconutWaterProdOrder(@PathVariable UUID id, @Valid @RequestBody CoconutWaterProdOrderDTO coconutWaterProdOrderDTOS) {
        log.info("Fully updating coconutWaterProdOrder with ID: {}", id);
        return new ResponseEntity<>(coconutWaterProdOrderService.update(id, coconutWaterProdOrderDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<CoconutWaterProdOrderDTO> patchCoconutWaterProdOrder(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CoconutWaterProdOrderDTO coconutWaterProdOrderDTOS = objectMapper.convertValue(updates, CoconutWaterProdOrderDTO.class);
        log.info("Partial updating coconutWaterProdOrder with ID: {}", id);
        return new ResponseEntity<>(coconutWaterProdOrderService.patch(id, coconutWaterProdOrderDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCoconutWaterProdOrderById(@PathVariable UUID id) {
        log.warn("Deleting coconutWaterProdOrder with ID: {}", id);
        coconutWaterProdOrderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
