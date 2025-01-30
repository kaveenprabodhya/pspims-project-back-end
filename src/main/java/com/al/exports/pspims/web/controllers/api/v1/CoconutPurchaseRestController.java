package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.CoconutPurchaseService;
import com.al.exports.pspims.shared.model.CoconutPurchaseDTO;
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
@RequestMapping(CoconutPurchaseRestController.BASE_URL)
@RequiredArgsConstructor
public class CoconutPurchaseRestController {
    public static final String BASE_URL = "/api/v1/coconutPurchases";
    private final CoconutPurchaseService coconutPurchaseService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @GetMapping
    public ResponseEntity<Page<CoconutPurchaseDTO>> getAllCoconutPurchases(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<CoconutPurchaseDTO> coconutPurchaseDTOS = coconutPurchaseService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(coconutPurchaseDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CoconutPurchaseDTO> getCoconutPurchaseById(@PathVariable UUID id){
        log.info("Fetching coconutPurchase with ID: {}", id);
        return new ResponseEntity<>(coconutPurchaseService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CoconutPurchaseDTO> createCoconutPurchase(@Valid @RequestBody CoconutPurchaseDTO coconutPurchaseDTOS){
        log.info("Creating coconutPurchase: {}", coconutPurchaseDTOS);
        return new ResponseEntity<>(coconutPurchaseService.create(coconutPurchaseDTOS), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CoconutPurchaseDTO> updateCoconutPurchase(@PathVariable UUID id,@Valid @RequestBody CoconutPurchaseDTO coconutPurchaseDTOS){
        log.info("Fully updating coconutPurchase with ID: {}", id);
        return new ResponseEntity<>(coconutPurchaseService.update(id, coconutPurchaseDTOS), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<CoconutPurchaseDTO> patchCoconutPurchase(@PathVariable UUID id, @Valid @RequestBody CoconutPurchaseDTO coconutPurchaseDTOS){
        log.info("Partial updating coconutPurchase with ID: {}", id);
        return new ResponseEntity<>(coconutPurchaseService.patch(id, coconutPurchaseDTOS), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCoconutPurchaseById(@PathVariable UUID id){
        log.warn("Deleting coconutPurchase with ID: {}", id);
        coconutPurchaseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
