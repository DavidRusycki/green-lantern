package com.dev.greenlantern.resources;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class StatusResource {

    @GetMapping
    public String check() {
        return "Application is up and running";
    }

}
