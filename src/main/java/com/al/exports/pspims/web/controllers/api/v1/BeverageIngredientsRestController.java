package com.al.exports.pspims.web.controllers.api.v1;

import com.al.exports.pspims.services.BeverageIngredientsService;
import com.al.exports.pspims.shared.model.BeverageIngredientsDTO;
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
@RequestMapping(BeverageIngredientsRestController.BASE_URL)
@RequiredArgsConstructor
public class BeverageIngredientsRestController {
    public static final String BASE_URL = "/api/v1/beverageIngredients";
    private final BeverageIngredientsService beverageIngredientsService;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping
    public ResponseEntity<Page<BeverageIngredientsDTO>> getAllBeverageIngredients(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        Page<BeverageIngredientsDTO> beverageIngredientsDTOS = beverageIngredientsService.findAll(PageRequest.of(pageNumber, pageSize));
        return new ResponseEntity<>(beverageIngredientsDTOS, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @GetMapping({"/{id}"})
    public ResponseEntity<BeverageIngredientsDTO> getBeverageIngredientsById(@PathVariable UUID id){
        log.info("Fetching beverageIngredients with ID: {}", id);
        return new ResponseEntity<>(beverageIngredientsService.findById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PostMapping
    public ResponseEntity<BeverageIngredientsDTO> createBeverageIngredients(@Valid @RequestBody BeverageIngredientsDTO beverageIngredientsDTOS){
        log.info("Creating beverageIngredients: {}", beverageIngredientsDTOS);
        return new ResponseEntity<>(beverageIngredientsService.create(beverageIngredientsDTOS), HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PutMapping({"/{id}"})
    public ResponseEntity<BeverageIngredientsDTO> updateBeverageIngredients(@PathVariable UUID id, @Valid @RequestBody BeverageIngredientsDTO beverageIngredientsDTOS){
        log.info("Fully updating beverageIngredients with ID: {}", id);
        return new ResponseEntity<>(beverageIngredientsService.update(id, beverageIngredientsDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @PatchMapping({"/{id}"})
    public ResponseEntity<BeverageIngredientsDTO> patchBeverageIngredients(@PathVariable UUID id, @Valid @RequestBody Object updates){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        BeverageIngredientsDTO beverageIngredientsDTOS = objectMapper.convertValue(updates, BeverageIngredientsDTO.class);
        log.info("Partial updating beverageIngredients with ID: {}", id);
        return new ResponseEntity<>(beverageIngredientsService.patch(id, beverageIngredientsDTOS), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_AGENT"})
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteBeverageIngredientsById(@PathVariable UUID id){
        log.warn("Deleting beverageIngredients with ID: {}", id);
        beverageIngredientsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
