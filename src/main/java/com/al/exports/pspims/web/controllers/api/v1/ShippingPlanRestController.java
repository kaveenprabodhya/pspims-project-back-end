package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.ShippingPlanService;
import com.al.exports.pspims.shared.model.ShippingPlanDTO;
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
@RequestMapping(ShippingPlanRestController.BASE_URL)
@RequiredArgsConstructor
public class ShippingPlanRestController {
    public static final String BASE_URL = "/api/v1/shippingPlans";
    private final ShippingPlanService shippingPlanService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @GetMapping
    public ResponseEntity<Page<ShippingPlanDTO>> getAllShippingPlans(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<ShippingPlanDTO> shippingPlanDTOS = shippingPlanService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(shippingPlanDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ShippingPlanDTO> getShippingPlanById(@PathVariable UUID id){
        log.info("Fetching shippingPlan with ID: {}", id);
        return new ResponseEntity<>(shippingPlanService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShippingPlanDTO> createShippingPlan(@Valid @RequestBody ShippingPlanDTO shippingPlanDTOS){
        log.info("Creating shippingPlan: {}", shippingPlanDTOS);
        return new ResponseEntity<>(shippingPlanService.create(shippingPlanDTOS), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ShippingPlanDTO> updateShippingPlan(@PathVariable UUID id,@Valid @RequestBody ShippingPlanDTO shippingPlanDTOS){
        log.info("Fully updating shippingPlan with ID: {}", id);
        return new ResponseEntity<>(shippingPlanService.update(id, shippingPlanDTOS), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<ShippingPlanDTO> patchShippingPlan(@PathVariable UUID id, @Valid @RequestBody ShippingPlanDTO shippingPlanDTOS){
        log.info("Partial updating shippingPlan with ID: {}", id);
        return new ResponseEntity<>(shippingPlanService.patch(id, shippingPlanDTOS), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteShippingPlanById(@PathVariable UUID id){
        log.warn("Deleting shippingPlan with ID: {}", id);
        shippingPlanService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
