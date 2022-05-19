package com.example.alab.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;

public class ResponseBuilder {
    public static ResponseEntity<?> build(Object data) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("request_time", String.valueOf(ZonedDateTime.now()));
        return ResponseEntity.ok().headers(headers).body(data);
    }
}
