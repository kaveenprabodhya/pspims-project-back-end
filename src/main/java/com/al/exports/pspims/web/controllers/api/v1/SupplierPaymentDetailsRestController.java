package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.SupplierPaymentDetailsService;
import com.al.exports.pspims.shared.model.SupplierPaymentDetailsDTO;
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
@RequestMapping(SupplierPaymentDetailsRestController.BASE_URL)
@RequiredArgsConstructor
public class SupplierPaymentDetailsRestController {
    public static final String BASE_URL = "/api/v1/supplierPaymentDetails";
    private final SupplierPaymentDetailsService supplierPaymentDetailsService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @GetMapping
    public ResponseEntity<Page<SupplierPaymentDetailsDTO>> getAllSupplierPaymentDetails(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                               @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<SupplierPaymentDetailsDTO> supplierPaymentDetailsDTOS = supplierPaymentDetailsService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(supplierPaymentDetailsDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<SupplierPaymentDetailsDTO> getSupplierPaymentDetailsById(@PathVariable UUID id){
        log.info("Fetching supplierPaymentDetail with ID: {}", id);
        return new ResponseEntity<>(supplierPaymentDetailsService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SupplierPaymentDetailsDTO> createSupplierPaymentsDetail(@Valid @RequestBody SupplierPaymentDetailsDTO supplierPaymentDetailsDTOS){
        log.info("Creating supplierPaymentDetail: {}", supplierPaymentDetailsDTOS);
        return new ResponseEntity<>(supplierPaymentDetailsService.create(supplierPaymentDetailsDTOS), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<SupplierPaymentDetailsDTO> updateSupplierPaymentsDetail(@PathVariable UUID id,@Valid @RequestBody SupplierPaymentDetailsDTO supplierPaymentDetailsDTOS){
        log.info("Fully updating supplierPaymentDetail with ID: {}", id);
        return new ResponseEntity<>(supplierPaymentDetailsService.update(id, supplierPaymentDetailsDTOS), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<SupplierPaymentDetailsDTO> patchSupplierPaymentsDetail(@PathVariable UUID id, @Valid @RequestBody SupplierPaymentDetailsDTO supplierPaymentDetailsDTOS){
        log.info("Partial updating supplierPaymentDetail with ID: {}", id);
        return new ResponseEntity<>(supplierPaymentDetailsService.patch(id, supplierPaymentDetailsDTOS), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteSupplierPaymentsDetailById(@PathVariable UUID id){
        log.warn("Deleting supplierPaymentDetail with ID: {}", id);
        supplierPaymentDetailsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
