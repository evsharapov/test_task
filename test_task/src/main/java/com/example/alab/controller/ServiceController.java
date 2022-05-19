package com.example.alab.controller;

import com.example.alab.service.FileService;
import com.example.alab.service.PersonService;
import com.example.alab.util.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.application.name}")
@RequiredArgsConstructor
public class ServiceController {

    private final PersonService personService;
    private final FileService fileService;

    @GetMapping("/lucky")
    public ResponseEntity<?> getLuckyUsers() {
        return ResponseBuilder.build(personService.getLuckyUsers());
    }

    @GetMapping("/map_of_lists")
    public ResponseEntity<?> getMap() {
        return ResponseBuilder.build(personService.getMap());
    }

    @GetMapping("/files")
    public ResponseEntity<?> writeToFiles() {
        return ResponseBuilder.build(fileService.writeToFiles(1000000));
    }
}
