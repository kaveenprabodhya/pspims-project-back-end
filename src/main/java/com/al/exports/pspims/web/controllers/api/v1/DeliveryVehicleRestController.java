package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.DeliveryVehicleService;
import com.al.exports.pspims.services.ShippingPlanService;
import com.al.exports.pspims.shared.model.DeliveryVehicleDTO;
import com.al.exports.pspims.shared.model.ShippingPlanDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(DeliveryVehicleRestController.BASE_URL)
@RequiredArgsConstructor
public class DeliveryVehicleRestController {
    public static final String BASE_URL = "/api/v1/deliveryVehicles";
    private final DeliveryVehicleService deliveryVehicleService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;
    private final ShippingPlanService shippingPlanService;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<DeliveryVehicleDTO>> getAllDeliveryVehicles(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<DeliveryVehicleDTO> deliveryVehicleDTOS = deliveryVehicleService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(deliveryVehicleDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<DeliveryVehicleDTO> getDeliveryVehicleById(@PathVariable UUID id) {
        log.info("Fetching deliveryVehicle with ID: {}", id);
        return new ResponseEntity<>(deliveryVehicleService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<DeliveryVehicleDTO> createDeliveryVehicle(@Valid @RequestBody DeliveryVehicleDTO deliveryVehicleDTOS) {
        log.info("Creating deliveryVehicle: {}", deliveryVehicleDTOS);
        return new ResponseEntity<>(deliveryVehicleService.create(deliveryVehicleDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<DeliveryVehicleDTO> updateDeliveryVehicle(@PathVariable UUID id, @Valid @RequestBody DeliveryVehicleDTO deliveryVehicleDTOS) {
        log.info("Fully updating deliveryVehicle with ID: {}", id);
        return new ResponseEntity<>(deliveryVehicleService.update(id, deliveryVehicleDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<DeliveryVehicleDTO> patchDeliveryVehicle(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        DeliveryVehicleDTO deliveryVehicleDTOS = objectMapper.convertValue(updates, DeliveryVehicleDTO.class);
        log.info("Partial updating deliveryVehicle with ID: {}", id);
        return new ResponseEntity<>(deliveryVehicleService.patch(id, deliveryVehicleDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteDeliveryVehicleById(@PathVariable UUID id) {
        log.warn("Attempting to delete delivery vehicle with ID: {}", id);

        boolean isInUse = shippingPlanService.isDeliveryVehicleInUse(id);

        if (isInUse) {
            String message = "Cannot delete delivery vehicle because it is assigned to one or more shipping plans.";
            log.warn(message);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        deliveryVehicleService.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
