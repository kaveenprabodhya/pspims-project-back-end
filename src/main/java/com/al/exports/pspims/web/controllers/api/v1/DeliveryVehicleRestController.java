package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.DeliveryVehicleService;
import com.al.exports.pspims.shared.model.DeliveryVehicleDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<Page<DeliveryVehicleDTO>> getAllDeliveryVehicles(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<DeliveryVehicleDTO> deliveryVehicleDTOS = deliveryVehicleService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(deliveryVehicleDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<DeliveryVehicleDTO> getDeliveryVehicleById(@PathVariable UUID id){
        log.info("Fetching deliveryVehicle with ID: {}", id);
        return new ResponseEntity<>(deliveryVehicleService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeliveryVehicleDTO> createDeliveryVehicle(@Valid @RequestBody DeliveryVehicleDTO deliveryVehicleDTOS){
        log.info("Creating deliveryVehicle: {}", deliveryVehicleDTOS);
        return new ResponseEntity<>(deliveryVehicleService.create(deliveryVehicleDTOS), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<DeliveryVehicleDTO> updateDeliveryVehicle(@PathVariable UUID id,@Valid @RequestBody DeliveryVehicleDTO deliveryVehicleDTOS){
        log.info("Fully updating deliveryVehicle with ID: {}", id);
        return new ResponseEntity<>(deliveryVehicleService.update(id, deliveryVehicleDTOS), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<DeliveryVehicleDTO> patchDeliveryVehicle(@PathVariable UUID id, @Valid @RequestBody DeliveryVehicleDTO deliveryVehicleDTOS){
        log.info("Partial updating deliveryVehicle with ID: {}", id);
        return new ResponseEntity<>(deliveryVehicleService.patch(id, deliveryVehicleDTOS), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteDeliveryVehicleById(@PathVariable UUID id){
        log.warn("Deleting deliveryVehicle with ID: {}", id);
        deliveryVehicleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
