package com.dev.greenlantern.resources;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class StatusResource {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String check() {
        JSONObject response = new JSONObject();
        response.put("status", "running");
        response.put("time", System.currentTimeMillis());

        return response.toString();
    }

}
