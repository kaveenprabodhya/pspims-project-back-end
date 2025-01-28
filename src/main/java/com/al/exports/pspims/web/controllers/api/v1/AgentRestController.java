package com.al.exports.pspims.web.controllers.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AgentRestController.BASE_URL)
public class AgentRestController {
    public static final String BASE_URL = "/api/v1/agent";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getName(){
        return "Hi";
    }
}
