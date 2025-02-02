package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.CustomerService;
import com.al.exports.pspims.shared.model.CustomerDTO;
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
@RequestMapping(CustomerRestController.BASE_URL)
@RequiredArgsConstructor
public class CustomerRestController {
    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> getAllCustomers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                             @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<CustomerDTO> customerDTOS = customerService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID id) {
        log.info("Fetching customer with ID: {}", id);
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTOS) {
        log.info("Creating customer: {}", customerDTOS);
        return new ResponseEntity<>(customerService.create(customerDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable UUID id, @Valid @RequestBody CustomerDTO customerDTOS) {
        log.info("Fully updating customer with ID: {}", id);
        return new ResponseEntity<>(customerService.update(id, customerDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable UUID id, @Valid @RequestBody Object updates) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CustomerDTO customerDTOS = objectMapper.convertValue(updates, CustomerDTO.class);
        log.info("Partial updating customer with ID: {}", id);
        return new ResponseEntity<>(customerService.patch(id, customerDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCustomerById(@PathVariable UUID id) {
        log.warn("Deleting customer with ID: {}", id);
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
