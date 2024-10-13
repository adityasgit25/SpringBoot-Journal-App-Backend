package com.adityamaheshwari.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // it states that it is not just an another class, its a rest-api controller.
public class HealthCheck {

    // get call
    @GetMapping("/health-check")
    public String healthCheck() {

        // whatever we return, it will convert to json.
        return "Ok";
    }
}
