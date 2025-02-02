package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.BeverageProdOrderService;
import com.al.exports.pspims.shared.model.BeverageProdOrderDTO;
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
@RequestMapping(BeverageProdOrderRestController.BASE_URL)
@RequiredArgsConstructor
public class BeverageProdOrderRestController {
    public static final String BASE_URL = "/api/v1/beverageProdOrders";
    private final BeverageProdOrderService beverageProdOrderService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<BeverageProdOrderDTO>> getAllBeverageProdOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                                @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<BeverageProdOrderDTO> beverageProdOrderDTOS = beverageProdOrderService.findAll(PageRequest.of(pageNumber, pageSize));
        return new ResponseEntity<>(beverageProdOrderDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<BeverageProdOrderDTO> getBeverageProdOrderById(@PathVariable UUID id){
        log.info("Fetching beverageProdOrder with ID: {}", id);
        return new ResponseEntity<>(beverageProdOrderService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<BeverageProdOrderDTO> createBeverageProdOrder(@Valid @RequestBody BeverageProdOrderDTO beverageProdOrderDTOS){
        log.info("Creating beverageProdOrder: {}", beverageProdOrderDTOS);
        return new ResponseEntity<>(beverageProdOrderService.create(beverageProdOrderDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<BeverageProdOrderDTO> updateBeverageProdOrder(@PathVariable UUID id, @Valid @RequestBody BeverageProdOrderDTO beverageProdOrderDTOS){
        log.info("Fully updating beverageProdOrder with ID: {}", id);
        return new ResponseEntity<>(beverageProdOrderService.update(id, beverageProdOrderDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<BeverageProdOrderDTO> patchBeverageProdOrder(@PathVariable UUID id, @Valid @RequestBody Object updates){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        BeverageProdOrderDTO beverageProdOrderDTOS = objectMapper.convertValue(updates, BeverageProdOrderDTO.class);
        log.info("Partial updating beverageProdOrder with ID: {}", id);
        return new ResponseEntity<>(beverageProdOrderService.patch(id, beverageProdOrderDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteBeverageProdOrderById(@PathVariable UUID id){
        log.warn("Deleting beverageProdOrder with ID: {}", id);
        beverageProdOrderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
