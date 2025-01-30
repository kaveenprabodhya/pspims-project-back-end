package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.PaymentDetailsService;
import com.al.exports.pspims.shared.model.PaymentDetailsDTO;
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
@RequestMapping(PaymentDetailsRestController.BASE_URL)
@RequiredArgsConstructor
public class PaymentDetailsRestController {
    public static final String BASE_URL = "/api/v1/paymentDetails";
    private final PaymentDetailsService paymentDetailsService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @GetMapping
    public ResponseEntity<Page<PaymentDetailsDTO>> getAllPaymentDetails(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                       @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<PaymentDetailsDTO> paymentDetailsDTOS = paymentDetailsService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(paymentDetailsDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PaymentDetailsDTO> getPaymentDetailsById(@PathVariable UUID id){
        log.info("Fetching paymentDetail with ID: {}", id);
        return new ResponseEntity<>(paymentDetailsService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentDetailsDTO> createPaymentDetails(@Valid @RequestBody PaymentDetailsDTO paymentDetailsDTOS){
        log.info("Creating paymentDetail: {}", paymentDetailsDTOS);
        return new ResponseEntity<>(paymentDetailsService.create(paymentDetailsDTOS), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<PaymentDetailsDTO> updatePaymentDetails(@PathVariable UUID id,@Valid @RequestBody PaymentDetailsDTO paymentDetailsDTOS){
        log.info("Fully updating paymentDetail with ID: {}", id);
        return new ResponseEntity<>(paymentDetailsService.update(id, paymentDetailsDTOS), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<PaymentDetailsDTO> patchPaymentDetails(@PathVariable UUID id, @Valid @RequestBody PaymentDetailsDTO paymentDetailsDTOS){
        log.info("Partial updating paymentDetail with ID: {}", id);
        return new ResponseEntity<>(paymentDetailsService.patch(id, paymentDetailsDTOS), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletePaymentDetailsById(@PathVariable UUID id){
        log.warn("Deleting paymentDetail with ID: {}", id);
        paymentDetailsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
