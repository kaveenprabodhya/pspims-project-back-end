package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.BeverageTypeService;
import com.al.exports.pspims.shared.model.BeverageTypeDTO;
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
@RequestMapping(BeverageTypeRestController.BASE_URL)
@RequiredArgsConstructor
public class BeverageTypeRestController {
    public static final String BASE_URL = "/api/v1/beverageTypes";
    private final BeverageTypeService beverageTypeService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<BeverageTypeDTO>> getAllBeverageTypes(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                              @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<BeverageTypeDTO> beverageTypeDTOS = beverageTypeService.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(beverageTypeDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<BeverageTypeDTO> getBeverageTypeById(@PathVariable UUID id){
        log.info("Fetching beverageType with ID: {}", id);
        return new ResponseEntity<>(beverageTypeService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<BeverageTypeDTO> createBeverageType(@Valid @RequestBody BeverageTypeDTO beverageTypeDTOS){
        log.info("Creating beverageType: {}", beverageTypeDTOS);
        return new ResponseEntity<>(beverageTypeService.create(beverageTypeDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<BeverageTypeDTO> updateBeverageType(@PathVariable UUID id,@Valid @RequestBody BeverageTypeDTO beverageTypeDTOS){
        log.info("Fully updating beverageType with ID: {}", id);
        return new ResponseEntity<>(beverageTypeService.update(id, beverageTypeDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<BeverageTypeDTO> patchBeverageType(@PathVariable UUID id, @Valid @RequestBody BeverageTypeDTO beverageTypeDTOS){
        log.info("Partial updating beverageType with ID: {}", id);
        return new ResponseEntity<>(beverageTypeService.patch(id, beverageTypeDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteBeverageTypeById(@PathVariable UUID id){
        log.warn("Deleting beverageType with ID: {}", id);
        beverageTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
