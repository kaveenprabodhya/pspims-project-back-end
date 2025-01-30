package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.OrderService;
import com.al.exports.pspims.shared.model.OrderDTO;
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
@RequestMapping(OrderRestController.BASE_URL)
@RequiredArgsConstructor
public class OrderRestController {
    public static final String BASE_URL = "/api/v1/orders";
    private final OrderService orderService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> getAllOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                              @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<OrderDTO> orderDTOS = orderService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(orderDTOS, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID id){
        log.info("Fetching order with ID: {}", id);
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTOS){
        log.info("Creating order: {}", orderDTOS);
        return new ResponseEntity<>(orderService.create(orderDTOS), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable UUID id,@Valid @RequestBody OrderDTO orderDTOS){
        log.info("Fully updating order with ID: {}", id);
        return new ResponseEntity<>(orderService.update(id, orderDTOS), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<OrderDTO> patchOrder(@PathVariable UUID id, @Valid @RequestBody OrderDTO orderDTOS){
        log.info("Partial updating order with ID: {}", id);
        return new ResponseEntity<>(orderService.patch(id, orderDTOS), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteOrderById(@PathVariable UUID id){
        log.warn("Deleting order with ID: {}", id);
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
