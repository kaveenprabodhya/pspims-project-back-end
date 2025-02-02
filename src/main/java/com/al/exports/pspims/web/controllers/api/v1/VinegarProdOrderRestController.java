package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.VinegarProdOrderService;
import com.al.exports.pspims.shared.model.VinegarProdOrderDTO;
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
@RequestMapping(VinegarProdOrderRestController.BASE_URL)
@RequiredArgsConstructor
public class VinegarProdOrderRestController {
    public static final String BASE_URL = "/api/v1/vinegarProdOrders";
    private final VinegarProdOrderService vinegarProdOrderService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<VinegarProdOrderDTO>> getAllVinegarProdOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                             @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<VinegarProdOrderDTO> vinegarProdOrderDTOS = vinegarProdOrderService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(vinegarProdOrderDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<VinegarProdOrderDTO> getVinegarProdOrderById(@PathVariable UUID id) {
        log.info("Fetching vinegarProdOrder with ID: {}", id);
        return new ResponseEntity<>(vinegarProdOrderService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<VinegarProdOrderDTO> createVinegarProdOrder(@Valid @RequestBody VinegarProdOrderDTO vinegarProdOrderDTOS) {
        log.info("Creating vinegarProdOrder: {}", vinegarProdOrderDTOS);
        return new ResponseEntity<>(vinegarProdOrderService.create(vinegarProdOrderDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<VinegarProdOrderDTO> updateVinegarProdOrder(@PathVariable UUID id, @Valid @RequestBody VinegarProdOrderDTO vinegarProdOrderDTOS) {
        log.info("Fully updating vinegarProdOrder with ID: {}", id);
        return new ResponseEntity<>(vinegarProdOrderService.update(id, vinegarProdOrderDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<VinegarProdOrderDTO> patchVinegarProdOrder(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        VinegarProdOrderDTO vinegarProdOrderDTOS = objectMapper.convertValue(updates, VinegarProdOrderDTO.class);
        log.info("Partial updating vinegarProdOrder with ID: {}", id);
        return new ResponseEntity<>(vinegarProdOrderService.patch(id, vinegarProdOrderDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteVinegarProdOrderById(@PathVariable UUID id) {
        log.warn("Deleting vinegarProdOrder with ID: {}", id);
        vinegarProdOrderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
